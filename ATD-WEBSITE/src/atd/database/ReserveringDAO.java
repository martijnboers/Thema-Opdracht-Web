/*******************************************************************************
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package atd.database;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import atd.domein.Klant;
import atd.domein.Reservering;

/**
 * @author Martijn
 *
 */

public class ReserveringDAO {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static Properties prop = new Properties();
	private static InputStream config = null;
	private KlantenDAO klantenDAO = new KlantenDAO();
	private static final String CONFIG_URL = "http://localhost:8080/ATD-WEBSITE/config/database.properties";

	// reservering toevoegen
	public boolean setReservering(Reservering reservering) throws SQLException {
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://" + prop.getProperty("host") + ":3306/"
							+ prop.getProperty("database"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();

			java.sql.Date sql_aankomst = new java.sql.Date(reservering
					.getAankomst().getTime());
			java.sql.Date sql_vertrek = new java.sql.Date(reservering
					.getVertrek().getTime());

			String query = "INSERT INTO `Reservering`(`aankomst`, `vertrek`, `klant_id` , `betaald`) VALUES(?, ?, ?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setDate(1, sql_aankomst);
			preparedStmt.setDate(2, sql_vertrek);
			preparedStmt.setInt(3, reservering.getKlant().getId());
			preparedStmt.setBoolean(4, reservering.getBetaald());

			if ((preparedStmt.executeUpdate()) > 0) {
				return true;
			}
		} catch (SQLException | IOException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
			return false;
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return false;

	}

	// alle reservering ophalen
	public ArrayList<Reservering> getAlleReservering() throws SQLException {
		ArrayList<Reservering> alleReserveringen = new ArrayList<>();
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://" + prop.getProperty("host") + ":3306/"
							+ prop.getProperty("database"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT  `aankomst`, `vertrek`, `klant_id` , `betaald` FROM `Reservering` WHERE 1");

			while (rs.next()) {

				alleReserveringen.add(new Reservering(klantenDAO.getKlant(rs
						.getInt(3)),
						new java.util.Date(rs.getDate(1).getTime()),
						new java.util.Date(rs.getDate(2).getTime()), rs
								.getBoolean(4)));

			}
			return alleReserveringen;

		} catch (SQLException | IOException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return null;
	}

	// kijken naar het aantal gepaarkeerde dagen wat nog niet betaald is
	public int geparkeerdeDagen(Klant klant) throws SQLException {
		int dagen = 0;
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://" + prop.getProperty("host") + ":3306/"
							+ prop.getProperty("database"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT `id`, `aankomst`, `vertrek`, `klant_id` FROM `Reservering` WHERE `klant_id` = "
					+ klant.getId() + " AND `betaald` = 0");

			while (rs.next()) {
				Calendar aankomst_cal = Calendar.getInstance();
				Calendar vertrek_cal = Calendar.getInstance();

				Date aankomst = new java.util.Date(rs.getDate(2).getTime());
				Date vertrek = new java.util.Date(rs.getDate(3).getTime());

				vertrek_cal.setTime(vertrek);
				aankomst_cal.setTime(aankomst);

				dagen += vertrek_cal.get(Calendar.DAY_OF_YEAR)
						- aankomst_cal.get(Calendar.DAY_OF_YEAR);

			}
			return dagen;

		} catch (SQLException | IOException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return dagen;
	}

	// een klant kan al zijn parkeer kosten betalen
	public boolean parkerenBetalen(Klant klant) throws SQLException {

		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://" + prop.getProperty("host") + ":3306/"
							+ prop.getProperty("database"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			String query = "UPDATE `Reservering` SET  `betaald`= 1 WHERE klant_id = "
					+ klant.getId() + " AND betaald = 0";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			if ((preparedStmt.executeUpdate()) > 0) {
				return true;
			}

		} catch (SQLException | IOException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return false;
	}
}