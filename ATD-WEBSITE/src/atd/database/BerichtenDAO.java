package atd.database;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import atd.domein.Bericht;
import atd.domein.StatusDB;
import atd.domein.User;

/**
 * @author Martijn
 * 
 *         TODO: Heel veel code kan hieruit weg
 *
 */

public class BerichtenDAO {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static Properties prop = new Properties();
	private static InputStream config = null;

	private static final String CONFIG_URL = "http://localhost:8080/ATD-WEBSITE/config/database.properties";

	/**
	 * Maakt nieuwe bericht aan in host
	 * 
	 * @return StatusDB Status
	 */
	public static StatusDB setBericht(String bericht, String tijd, User user) {
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://" + prop.getProperty("host") + ":3306/" + prop.getProperty("database"), prop.getProperty("dbuser"),
					prop.getProperty("dbpassword"));
			st = con.createStatement();

			String query = "INSERT INTO Berichten(Bericht, Tijd, User) VALUES(?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, bericht);
			preparedStmt.setString(2, tijd);
			preparedStmt.setInt(3, user.getId());
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
	 * Verwijderd bericht uit host, of bericht verwijderd mag worden moet
	 * bepaald worden in hoger level
	 * 
	 * @param id
	 *            Id van het bericht, kan opgehaald worden met bericht.getId()
	 * 
	 * @return StatusDB Status
	 */
	public static StatusDB removeBericht(int id) {
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://" + prop.getProperty("host") + ":3306/" + prop.getProperty("database"), prop.getProperty("dbuser"),
					prop.getProperty("dbpassword"));
			st = con.createStatement();

			String query = "DELETE FROM Berichten WHERE id = ?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, id);
			preparedStmt.execute();
			return StatusDB.SUCCESS;

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
	}

	/**
	 * Geeft alle Berichten in de host terug als ArrayList
	 * 
	 * @return ArrayList<Klant>
	 * @throws SQLException
	 */
	public static ArrayList<Bericht> getAllBerichten() throws SQLException {
		ArrayList<Bericht> alleBerichten = new ArrayList<>();
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://" + prop.getProperty("host") + ":3306/" + prop.getProperty("database"), prop.getProperty("dbuser"),
					prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Berichten ORDER BY id DESC LIMIT 0, 6");

			while (rs.next()) {
				alleBerichten.add(new Bericht(rs.getInt(1), rs.getString(2), rs.getString(3), UsersDAO.getUser(rs.getInt(4))));
			}
			return alleBerichten;

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