package atd.database;

import java.io.File;
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
import atd.domein.User;

/**
 * @author Martijn
 * 
 *         TODO: Heel veel code kan hieruit weg TODO: Auth moet veilig zijn (MD5 + SALT)
 *
 */

public class dbUsers {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static Properties prop = new Properties();
	private static InputStream config = null;

	public static void main(String[] args) throws SQLException {
		System.out.println(authUser("martijn", "pwd"));
	}

	/**
	 * Maakt nieuwe User gebruiker aan in database
	 * 
	 * @param usrIn
	 *            Ingegeven user
	 * @param password
	 *            Wachtwoord word niet opgeslagen in User object
	 * @return
	 */
	public static StatusDB setUser(User usrIn, String password) {
		try {
			config = new FileInputStream("/config/database.properties");
			prop.load(config);
			Connection con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();

			int priv = 3;
			if (usrIn.getPriv() == Privilege.ADMIN) {
				priv = 1;
			} else if (usrIn.getPriv() == Privilege.MONTEUR) {
				priv = 2;
			}
			String query = "INSERT INTO Users(username, naam, priv, password) VALUES(?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, usrIn.getUsername());
			preparedStmt.setString(2, usrIn.getNaam());
			preparedStmt.setInt(3, priv);
			preparedStmt.setString(4, password);
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
	 * Geeft User object terug met gegeven id
	 * 
	 * @param id
	 *            Database user ID
	 * @return User
	 * @throws SQLException
	 */
	public static User getUser(int id) throws SQLException {
		try {
			config = new URL("http://db.plebian.nl/3c0nf1g/database.properties").openStream();
			prop.load(config);
			Connection con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Users WHERE id='" + id + "'");

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
				return new User(rs.getString(2), rs.getString(3), priv);
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
	 * Geeft alle Users in de database terug als ArrayList
	 * 
	 * @return ArrayList<User>
	 * @throws SQLException
	 */
	public static ArrayList<User> getAllUsers() throws SQLException {
		ArrayList<User> allUsers = new ArrayList<>();
		try {
			config = new URL("http://db.plebian.nl/3c0nf1g/database.properties").openStream();
			prop.load(config);
			con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Users");

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
				allUsers.add(new User(rs.getString(2), rs.getString(3), priv));
			}
			return allUsers;

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
	public static boolean userExist(int id) {
		try {
			config = new URL("http://db.plebian.nl/3c0nf1g/database.properties").openStream();
			prop.load(config);
			con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Users WHERE id='" + id + "'");
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
	 * @param username
	 * @param password
	 * @return boolean
	 */
	public static boolean authUser(String username, String password) {
		try {
			config = new URL("http://db.plebian.nl/3c0nf1g/database.properties").openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT password FROM Users WHERE username='" + username + "'");
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
	 * Zoek gebruiker in database en return User object
	 * 
	 * @param username
	 *            Gebruikernaam gebruiker
	 * @param fullName
	 *            Volledige naam gebruiker
	 * @return
	 */
	public static User searchUser(String username) {
		try {
			config = new URL("http://db.plebian.nl/3c0nf1g/database.properties").openStream();
			prop.load(config);
			con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Users WHERE username='" + username + "'");
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
				return new User(rs.getString(2), rs.getString(3), priv);
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
