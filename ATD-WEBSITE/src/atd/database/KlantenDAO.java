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

import java.io.FileInputStream;
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
import java.util.Properties;

import atd.domein.Privilege;
import atd.domein.StatusDB;
import atd.domein.Klant;

/**
 * @author Martijn
 * 
 *         TODO: Heel veel code kan hieruit weg TODO: Auth moet veilig zijn (MD5 + SALT)
 *
 */

public class KlantenDAO {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static Properties prop = new Properties();
	private static InputStream config = null;
	
	private static final String CONFIG_URL = "http://localhost:8080/ATD-WEBSITE/config/database.properties";

	/**
	 * Maakt nieuwe Klant gebruiker aan in host
	 * 
	 * @param klantIn
	 *            Ingegeven Klant
	 * @param password
	 *            Wachtwoord word niet opgeslagen in User object
	 * @return StatusDB Status
	 */
	public static StatusDB setKlant(Klant klantIn, String password) {
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("host") + ":3306/" + prop.getProperty("database"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();

			int priv = 3;
			if (klantIn.getPriv() == Privilege.ADMIN) {
				priv = 1;
			} else if (klantIn.getPriv() == Privilege.MONTEUR) {
				priv = 2;
			}
			String query = "INSERT INTO Klanten(Username, Password, Volledigenaam, Postcode, Email, Auto, Priv) VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, klantIn.getUsername());
			preparedStmt.setString(2, password);
			preparedStmt.setString(3, klantIn.getVolledigeNaam());
			preparedStmt.setString(4, klantIn.getPostcode());
			preparedStmt.setString(5, klantIn.getEmail());
			preparedStmt.setInt(6, klantIn.getDeAuto().getId());
			preparedStmt.setInt(7, priv);
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
	 * Geeft Klant object terug met gegeven id
	 * 
	 * @param id
	 *            host Klant ID
	 * @return Klant
	 * @throws SQLException
	 */
	public static Klant getKlant(int id) throws SQLException {
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("host") + ":3306/" + prop.getProperty("database"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Klanten WHERE id='" + id + "'");

			if (rs.next()) {
				Privilege priv = Privilege.KLANT;
				switch (rs.getInt(7)) {
				case 1:
					priv = Privilege.ADMIN;
					break;
				case 2:
					priv = Privilege.MONTEUR;
					break;
				case 3:
					priv = Privilege.KLANT;
				}
				return new Klant(rs.getInt(1), rs.getString(4), rs.getString(3), rs.getString(4), rs.getString(5), null, priv);
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
		return null;
	}

	/**
	 * Geeft alle Klants in de host terug als ArrayList
	 * 
	 * @return ArrayList<Klant>
	 * @throws SQLException
	 */
	public static ArrayList<Klant> getAllKlanten() throws SQLException {
		ArrayList<Klant> allKlanten = new ArrayList<>();
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("host") + ":3306/" + prop.getProperty("database"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Klanten");

			while (rs.next()) {
				Privilege priv = Privilege.KLANT;
				switch (rs.getInt(7)) {
				case 1:
					priv = Privilege.ADMIN;
					break;
				case 2:
					priv = Privilege.MONTEUR;
					break;
				case 3:
					priv = Privilege.KLANT;
				}
				allKlanten.add(new Klant(rs.getInt(1), rs.getString(4), rs.getString(3), rs.getString(4), rs.getString(5), null, priv));
			}
			return allKlanten;

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

	/**
	 * Hiermee kun je eigen SQLQueries uitvoeren. Wordt voornamelijk gebruikt in host.java
	 * 
	 * @param input
	 *            Rauwe SQL query, geen ; invoeren!
	 * @return boolean
	 */
	public static boolean KlantExist(int id) {
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("host") + ":3306/" + prop.getProperty("database"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Klanten WHERE id='" + id + "'");
			if (rs.next()) {
				if (rs.getString(1).equals(null)) {
					return false;
				}
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
		return true;
	}

	/**
	 * Controleert gebruikerswachtwoord met host, return als goed is true
	 * 
	 * @param Klantname
	 * @param password
	 * @return boolean
	 */
	public static boolean authKlant(String username, String password) {
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("host") + ":3306/" + prop.getProperty("database"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT password FROM Klanten WHERE Username='" + username + "'");
			if (rs.next()) {
				if (rs.getString(1).equals(password)) {
					return true;
				}
			} else {
				return false;
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

	/**
	 * Zoek gebruiker in host en return Klant object
	 * 
	 * @param Klantname
	 *            Gebruikernaam gebruiker
	 * @param fullName
	 *            Volledige naam gebruiker
	 * @return
	 */
	public static Klant searchKlant(String Klantname) {
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("host") + ":3306/" + prop.getProperty("database"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Klanten WHERE Username='" + Klantname + "'");
			if (rs.next()) {
				Privilege priv = Privilege.KLANT;
				switch (rs.getInt(8)) {
				case 1:
					priv = Privilege.ADMIN;
					break;
				case 2:
					priv = Privilege.MONTEUR;
					break;
				case 3:
					priv = Privilege.KLANT;
				}
				// TODO: Auto werkt nog niet goed
				return new Klant(rs.getInt(1), rs.getString(4), rs.getString(3), rs.getString(4), rs.getString(5), null, priv);
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
		return null;
	}
}
