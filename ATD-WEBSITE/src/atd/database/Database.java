package atd.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import atd.domein.*;

public class Database {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static Properties prop = new Properties();
	private static InputStream config = null;

	public static void main(String[] args) throws SQLException {
		User x = getUser(2);
		System.out.println(x.getId() + ":" +  x.getNaam());
	}

	/**
	 * Geeft User object terug met gegeven id
	 * 
	 * @param id	Database user ID
	 * @return 		User
	 * @throws 		SQLException
	 */
	public static User getUser(int id) throws SQLException {
		try {
			config = new FileInputStream("config/database.properties");
			prop.load(config);
			con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"),
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
	 * Hiermee kun je eigen SQLQueries uitvoeren. Wordt voornamelijk gebruikt in Database.java
	 * 
	 * @param input
	 *            Rauwe SQL query, geen ; invoeren!
	 * @return boolean
	 */
	public static ResultSet sqlQuery(String input) {
		try {
			config = new FileInputStream("config/database.properties");
			prop.load(config);
			con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery(input);
			return rs;

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
