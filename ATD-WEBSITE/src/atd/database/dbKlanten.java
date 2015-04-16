package atd.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import atd.domein.Auto;

/**
 * @author Martijn
 *  
 * TODO: Heel veel code kan hieruit weg
 * TODO: Auth moet veilig zijn (MD5 + SALT)
 *
 */

public class dbKlanten {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static Properties prop = new Properties();
	private static InputStream config = null;

	/**
	 * Maakt nieuwe Klant gebruiker aan in database
	 * @param klantIn	Ingegeven Klant
	 * @param password Wachtwoord word niet opgeslagen in User object
	 * @return StatusDB Status
	 */
	public static StatusDB setKlant(Klant klantIn, String password) {
		try {
			config = new FileInputStream("config/database.properties");
			prop.load(config);
			Connection con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
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
			preparedStmt.setInt(6, 1);
			preparedStmt.setInt(7, priv);
			preparedStmt.execute();

		} catch (SQLException | IOException ex) {
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
	 *            Database Klant ID
	 * @return Klant
	 * @throws SQLException
	 */
	public static Klant getKlant(int id) throws SQLException {
		try {
			config = new FileInputStream("config/database.properties");
			prop.load(config);
			Connection con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"),
					prop.getProperty("dbKlant"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Klanten WHERE id='" + id + "'");

			if (rs.next()) {
				Privilege priv = Privilege.KLANT;
				switch (rs.getInt(4)) {
				case 1:
					priv = Privilege.ADMIN;
					break;
				case 2:
					priv = Privilege.MONTEUR;
					break;
				case 3:
					priv = Privilege.KLANT;
				}
				return new Klant(rs.getString(4), rs.getString(3), rs.getString(4), rs.getString(5), null, priv);
			}

		} catch (SQLException | IOException ex) {
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
	 * Geeft alle Klants in de database terug als ArrayList
	 * 
	 * @return ArrayList<Klant>
	 * @throws SQLException
	 */
	public static ArrayList<Klant> getAllKlanten() throws SQLException {
		ArrayList<Klant> allKlanten = new ArrayList<>();
		try {
			config = new FileInputStream("config/database.properties");
			prop.load(config);
			con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"),
					prop.getProperty("dbKlant"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Klanten");

			while (rs.next()) {
				Privilege priv = Privilege.KLANT;
				switch (rs.getInt(4)) {
				case 1:
					priv = Privilege.ADMIN;
					break;
				case 2:
					priv = Privilege.MONTEUR;
					break;
				case 3:
					priv = Privilege.KLANT;
				}
				allKlanten.add(new Klant(rs.getString(4), rs.getString(3), rs.getString(4), rs.getString(5), null, priv));
			}
			return allKlanten;

		} catch (SQLException | IOException ex) {
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
	 * Hiermee kun je eigen SQLQueries uitvoeren. Wordt voornamelijk gebruikt in Database.java
	 * 
	 * @param input
	 *            Rauwe SQL query, geen ; invoeren!
	 * @return boolean
	 */
	public static boolean KlantExist(int id) {
		try {
			config = new FileInputStream("config/database.properties");
			prop.load(config);
			con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"),
					prop.getProperty("dbKlant"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Klants WHERE id='" + id + "'");
			if (rs.next()) {
				if (rs.getString(1).equals(null)) {
					return false;
				}

			}

		} catch (SQLException | IOException ex) {
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
	 * Controleert gebruikerswachtwoord met database, return als goed is true
	 * 
	 * @param Klantname
	 * @param password
	 * @return boolean
	 */
	public static boolean authKlant(String username, String password) {
		try {
			config = new FileInputStream("config/database.properties");
			prop.load(config);
			con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"),
					prop.getProperty("dbKlant"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT password FROM Klanten WHERE Klantname='" + username + "'");
			if (rs.next()) {
				if (rs.getString(1).equals(password)) {
					return true;
				}
			} else {
				return false;
			}

		} catch (SQLException | IOException ex) {
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
	 * Zoek gebruiker in database en return Klant object
	 * 
	 * @param Klantname
	 *            Gebruikernaam gebruiker
	 * @param fullName
	 *            Volledige naam gebruiker
	 * @return
	 */
	public static Klant searchKlant(String Klantname, String fullName) {
		try {
			config = new FileInputStream("config/database.properties");
			prop.load(config);
			con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"),
					prop.getProperty("dbKlant"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Klanten WHERE username='" + Klantname + "' AND naam='" + fullName + "'");
			if (rs.next()) {
				Privilege priv = Privilege.KLANT;
				switch (rs.getInt(4)) {
				case 1:
					priv = Privilege.ADMIN;
					break;
				case 2:
					priv = Privilege.MONTEUR;
					break;
				case 3:
					priv = Privilege.KLANT;
				}
				return new Klant(rs.getString(4), rs.getString(3), rs.getString(4), rs.getString(5), null, priv);
			}

		} catch (SQLException | IOException ex) {
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
