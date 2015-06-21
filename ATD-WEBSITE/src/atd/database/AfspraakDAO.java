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
import java.util.Date;
import java.util.Properties;

import atd.domein.Afspraak;
import atd.domein.AfspraakStatus;
import atd.domein.Auto;
import atd.domein.Klant;
import atd.domein.StatusDB;
import atd.domein.User;

/**
 * @author Martijn/klaas
 *
 */

public class AfspraakDAO {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static Properties prop = new Properties();
	private static InputStream config = null;

	private static final String CONFIG_URL = "http://localhost:8080/ATD-WEBSITE/config/database.properties";
	private KlantenDAO klantenDAO = new KlantenDAO();
	private UsersDAO userDAO = new UsersDAO();
	private AutoDAO autoDAO = new AutoDAO();

	public StatusDB setAfspraak(Afspraak afspraak) {
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://" + prop.getProperty("host") + ":3306/"
							+ prop.getProperty("database"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();

			String query = "INSERT INTO Afspraak(Klant, Monteur, Auto, Datum, Omschrijving) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, afspraak.getKlant().getId());
			preparedStmt.setInt(2, afspraak.getMonteur().getId());
			preparedStmt.setInt(1, afspraak.getAuto().getId());
			preparedStmt.setDate(1, new java.sql.Date(afspraak.getDatum()
					.getTime()));
			preparedStmt.setInt(1, afspraak.getKlant().getId());
			preparedStmt.execute();

		} catch (SQLException | IOException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
			return StatusDB.INCORRECT;
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
		return StatusDB.UNKOWN;
	}

	public ArrayList<Afspraak> getAlleAfspraken() {
		ArrayList<Afspraak> alleAfspraken = new ArrayList<>();

		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://" + prop.getProperty("host") + ":3306/"
							+ prop.getProperty("database"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Afspraken");

			while (rs.next()) {
				int id = rs.getInt(1);
				Klant klant = klantenDAO.getKlant(rs.getInt(2));
				User user = userDAO.getUser(rs.getInt(3));
				Auto auto = autoDAO.getAutoByID(rs.getInt(4));
				Date datum = new java.util.Date(rs.getDate(5).getTime());
				String omschrijving = rs.getString(6);
				AfspraakStatus status = AfspraakStatus.valueOf(rs.getString(7));

				Afspraak afspraak = new Afspraak(klant, user, auto, datum,
						omschrijving, status);
				afspraak.setId(rs.getInt(1));
				alleAfspraken.add(afspraak);
			}
			return alleAfspraken;

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

	public ArrayList<Afspraak> getAfsprakenMonteur(User monteur) {

		ArrayList<Afspraak> alleAfspraken = new ArrayList<>();

		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://" + prop.getProperty("host") + ":3306/"
							+ prop.getProperty("database"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM `Afspraken` WHERE `Monteur_ID` = "
					+ monteur.getId() + "");

			while (rs.next()) {

				Klant klant = klantenDAO.getKlant(rs.getInt(2));
				User user = userDAO.getUser(rs.getInt(3));
				Auto auto = autoDAO.getAutoByID(rs.getInt(4));
				Date datum = new java.util.Date(rs.getDate(5).getTime());
				String omschrijving = rs.getString(6);
				AfspraakStatus status = AfspraakStatus.valueOf(rs.getString(7));

				Afspraak afspraak = new Afspraak(klant, user, auto, datum,
						omschrijving, status);
				afspraak.setId(rs.getInt(1));
				alleAfspraken.add(afspraak);
			}
			return alleAfspraken;

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
}