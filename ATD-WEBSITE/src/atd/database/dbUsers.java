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
import atd.domein.User;

public class dbUsers {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static Properties prop = new Properties();
	private static InputStream config = null;

	public static void main(String[] args) throws SQLException {
		ArrayList<User> x1 = getAllUsers();
		for (User s : x1) {
			System.out.println(s.getNaam());
		}
		setUser(new User(0, "henkie2", "Henka", Privilege.ADMIN));
	}

	public static StatusDB setUser(User usrIn) {
//		if (userExist(usrIn.getUsername())){
//			return StatusDB.EXIST;
//		}
		try {
			config = new FileInputStream("config/database.properties");
			prop.load(config);
			Connection con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();

			int priv = 3;
			if (usrIn.getPriv() == Privilege.ADMIN) {
				priv = 1;
			} else if (usrIn.getPriv() == Privilege.MONTEUR) {
				priv = 2;
			}
			String query = "INSERT INTO Users(username, naam, priv) VALUES(?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, usrIn.getUsername());
			preparedStmt.setString(2, usrIn.getNaam());
			preparedStmt.setInt(3, priv);
			preparedStmt.execute();
			return StatusDB.SUCCESS;

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
			config = new FileInputStream("config/database.properties");
			prop.load(config);
			Connection con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
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
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), priv);
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
			config = new FileInputStream("config/database.properties");
			prop.load(config);
			con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
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
				allUsers.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), priv));
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
	 * Functie controlleerd of gebruiker bestaat, zo ja return hij true
	 * 
	 * @param input
	 *            id van gebruiker
	 * @return boolean
	 */
	public static boolean userExist(String username) {
		try {
			config = new FileInputStream("config/database.properties");
			prop.load(config);
			con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Users WHERE username='" + username + "'");
			if (rs.next()){
				if (rs.getString(1).equals(null)){
					return false;
				}
				else {
					return true;
				}
			}
			return false;

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
}
