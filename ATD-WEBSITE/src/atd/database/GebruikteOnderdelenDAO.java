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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import atd.domein.Afspraak;
import atd.domein.Onderdeel;

/**
 * @author Martijn/Klaas
 * 
 *         TODO: Heel veel code kan hieruit weg
 *
 */

public class GebruikteOnderdelenDAO {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static Properties prop = new Properties();
	private static InputStream config = null;
	private OnderdelenDAO onderdelenDAO = new OnderdelenDAO();
	private static final String CONFIG_URL = "http://localhost:8080/ATD-WEBSITE/config/database.properties";

	/**
	 * Maakt nieuw Onderdeel aan in host
	 * 
	 * @param onderdeelIn
	 * @return
	 */
	public boolean setOnderdeel(Onderdeel onderdeel, Afspraak afspraak,
			int aantal) {
		boolean result = false;
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://" + prop.getProperty("host") + ":3306/"
							+ prop.getProperty("database"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();

			String query = "INSERT INTO `GebruikteOnderdeel`( `Klant_ID`, `Onderdeel_ID`, `aantal`) VALUES ('"
					+ afspraak.getID()
					+ "','"
					+ onderdeel.getID()
					+ "',"
					+ aantal + ")";

			if (st.executeUpdate(query) == 1) {
				result = true;
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
		return result;
	}

	/**
	 * Geeft alle Onderdelen in de host terug als ArrayList
	 * 
	 * @return ArrayList<Klant>
	 * @throws SQLException
	 */
	public ArrayList<Onderdeel> getOnderdelen(Afspraak afspraak)
			throws SQLException {
		ArrayList<Onderdeel> alleOnderdelen = new ArrayList<>();

		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://" + prop.getProperty("host") + ":3306/"
							+ prop.getProperty("database"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM  `GebruiktOnderdeel` WHERE Afspraak_ID ="
					+ afspraak.getID() + "");

			while (rs.next()) {
				Onderdeel ond = onderdelenDAO.getOnderdeel(rs.getInt(2));
				ond.setAantal(rs.getInt(3));
				alleOnderdelen.add(ond);
			}
			return alleOnderdelen;

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
