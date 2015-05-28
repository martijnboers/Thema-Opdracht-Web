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
import atd.domein.Onderdeel;

/**
 * @author Martijn
 * 
 *         TODO: Heel veel code kan hieruit weg
 *
 */

public class OnderdelenDAO {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static Properties prop = new Properties();
	private static InputStream config = null;

	private static final String CONFIG_URL = "http://localhost:8080/ATD-WEBSITE/config/database.properties";

	/**
	 * Maakt nieuw Onderdeel aan in host
	 * 
	 * @param onderdeelIn
	 * @return
	 */
	public static StatusDB setOnderdeel(Onderdeel onderdeelIn) {
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://" + prop.getProperty("host") + ":3306/"
							+ prop.getProperty("database"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();

			String query = "INSERT INTO Onderdeel(Naam, Type, Voorraad, Prijs) VALUES(?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, onderdeelIn.getNaam());
			preparedStmt.setString(2, onderdeelIn.getType());
			preparedStmt.setInt(3, onderdeelIn.getVoorraad());
			preparedStmt.setDouble(4, onderdeelIn.getPrijs());
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
	 *            host Onderdeel ID
	 * @return Onderdeel
	 * @throws SQLException
	 */
	public Onderdeel getOnderdeel(int id) throws SQLException {
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://" + prop.getProperty("host") + ":3306/"
							+ prop.getProperty("database"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Onderdeel WHERE id='" + id
					+ "'");

			if (rs.next()) {
				return new Onderdeel(rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getDouble(5));
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
	 * Geeft alle Onderdelen in de host terug als ArrayList
	 * 
	 * @return ArrayList<Klant>
	 * @throws SQLException
	 */
	public static ArrayList<Onderdeel> getAllOnderdelen() throws SQLException {
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
			rs = st.executeQuery("SELECT * FROM Onderdeel");

			while (rs.next()) {
				Onderdeel ond = new Onderdeel(rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getDouble(5));
				ond.setID(rs.getInt(1));
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

	/**
	 * Maakt nieuw Onderdeel aan in host
	 * 
	 * @param onderdeelIn
	 * @param aantal
	 * @return
	 */
	public StatusDB updateOnderdeel(Onderdeel onderdeelIn, int aantal) {
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://" + prop.getProperty("host") + ":3306/"
							+ prop.getProperty("database"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();

			String query = "UPDATE Onderdeel SET Voorraad='" + aantal
					+ "' WHERE `Prijs` = " + onderdeelIn.getPrijs()
					+ " and `Type` = '" + onderdeelIn.getType()
					+ "' and `Naam` = '" + onderdeelIn.getNaam() + "'";
			PreparedStatement preparedStmt = con.prepareStatement(query);
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
}
