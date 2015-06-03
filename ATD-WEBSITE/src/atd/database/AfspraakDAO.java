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
import atd.domein.Bericht;
import atd.domein.StatusDB;

/**
 * @author Martijn
 *
 */

public class AfspraakDAO {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static Properties prop = new Properties();
	private static InputStream config = null;

	private static final String CONFIG_URL = "http://localhost:8080/ATD-WEBSITE/config/database.properties";

	public static void main(String[] args) throws SQLException {
		//setAfspraak(new Afspraak(0, KlantenDAO.getKlant(3), UsersDAO.getUser(9), AutoDAO.searchAuto("12-32-32"), "2015-06-03 12:23:29", "Maak he 3"));

		ArrayList<Afspraak> alleAfspraken = getAlleAfspraken();
		for (Afspraak x : alleAfspraken) {
			System.out.println(x.getDatum());
		}
	}

	public static StatusDB setAfspraak(Afspraak afspraak) {
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://" + prop.getProperty("host") + ":3306/" + prop.getProperty("database"), prop.getProperty("dbuser"),
					prop.getProperty("dbpassword"));
			st = con.createStatement();

			String query = "INSERT INTO Afspraak(Klant, Monteur, Auto, Datum, Omschrijving) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, afspraak.getKlant().getId());
			preparedStmt.setInt(2, afspraak.getMonteur().getId());
			preparedStmt.setInt(3, afspraak.getAuto().getId());
			preparedStmt.setString(4, afspraak.getDatum());
			preparedStmt.setString(5, afspraak.getOmschrijving());
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

	/**
	 * Geeft alle Berichten in de host terug als ArrayList
	 * 
	 * @return ArrayList<Klant>
	 * @throws SQLException
	 */
	public static ArrayList<Afspraak> getAlleAfspraken() throws SQLException {
		ArrayList<Afspraak> alleAfspraken = new ArrayList<>();
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://" + prop.getProperty("host") + ":3306/" + prop.getProperty("database"), prop.getProperty("dbuser"),
					prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Afspraak");

			while (rs.next()) {
				alleAfspraken.add(new Afspraak(rs.getInt(1), KlantenDAO.getKlant(rs.getInt(2)), UsersDAO.getUser(rs.getInt(3)), AutoDAO
						.getAuto(4), rs.getString(5), rs.getString(6)));
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