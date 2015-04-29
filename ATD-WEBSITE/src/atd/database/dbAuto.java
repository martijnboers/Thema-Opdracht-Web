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
import atd.domein.Auto;

/**
 * @author Martijn
 * 
 *         TODO: Heel veel code kan hieruit weg
 *
 */

public class dbAuto {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static Properties prop = new Properties();
	private static InputStream config = null;

	/**
	 * Maakt nieuwe Auto aan in database
	 * 
	 * @param klantIn
	 *            Ingegeven Klant
	 * @param password
	 *            Wachtwoord word niet opgeslagen in User object
	 * @return StatusDB Status
	 */
	public static StatusDB setAuto(Auto autoIn) {
		try {
			config = new URL("http://db.plebian.nl/3c0nf1g/database.properties").openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();

			String query = "INSERT INTO Auto(Kenteken, Merk, Type) VALUES(?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, autoIn.getKenteken());
			preparedStmt.setString(2, autoIn.getMerk());
			preparedStmt.setString(3, autoIn.getType());
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
	 * Zoek gebruiker in database en return Klant object
	 * 
	 * @param Klantname
	 *            Gebruikernaam gebruiker
	 * @param fullName
	 *            Volledige naam gebruiker
	 * @return
	 */
	public static Auto searchAuto(String kenteken) {
		try {
			config = new URL("http://db.plebian.nl/3c0nf1g/database.properties").openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"), prop.getProperty("dbKlant"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Auto WHERE kenteken='" + kenteken + "'");
			if (rs.next()) {
				return new Auto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
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