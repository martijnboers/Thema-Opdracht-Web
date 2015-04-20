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
import atd.domein.Onderdeel;

/**
 * @author Martijn
 *  
 * TODO: Heel veel code kan hieruit weg
 * TODO: Auth moet veilig zijn (MD5 + SALT)
 *
 */

public class dbOnderdelen {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static Properties prop = new Properties();
	private static InputStream config = null;

	/**
	 * Maakt nieuw Onderdeel aan in database
	 * 
	 * @param onderdeelIn
	 * @return
	 */
	public static StatusDB setOnderdeel(Onderdeel onderdeelIn) {
		try {
			config = new FileInputStream("config/database.properties");
			prop.load(config);
			Connection con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();

			String query = "INSERT INTO Onderdeel(Naam, Type, Voorraad, Prijs) VALUES(?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, onderdeelIn.getNaam());
			preparedStmt.setString(2, onderdeelIn.getType());
			preparedStmt.setInt(3, onderdeelIn.getVoorraad());
			preparedStmt.setDouble(4, onderdeelIn.getPrijs());
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
	 *            Database Onderdeel ID
	 * @return Onderdeel
	 * @throws SQLException
	 */
	public static Onderdeel getKlant(int id) throws SQLException {
		try {
			config = new FileInputStream("config/database.properties");
			prop.load(config);
			Connection con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"),
					prop.getProperty("dbKlant"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Onderdeel WHERE id='" + id + "'");

			if (rs.next()) {
				return new Onderdeel(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5));
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
	 * Geeft alle Onderdelen in de database terug als ArrayList
	 * 
	 * @return ArrayList<Klant>
	 * @throws SQLException
	 */
	public static ArrayList<Onderdeel> getAllOnderdelen() throws SQLException {
		ArrayList<Onderdeel> alleOnderdelen = new ArrayList<>();
		try {
			config = new FileInputStream("config/database.properties");
			prop.load(config);
			con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"),
					prop.getProperty("dbKlant"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Onderdeel");

			while (rs.next()) {
				alleOnderdelen.add(new Onderdeel(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5)));
			}
			return alleOnderdelen;

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
	 * Maakt nieuw Onderdeel aan in database
	 * 
	 * @param onderdeelIn
	 * @return
	 */
	public static StatusDB updateOnderdeel(Onderdeel onderdeelIn) {
		try {
			config = new FileInputStream("config/database.properties");
			prop.load(config);
			Connection con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();

			String query = "UPDATE Onderdeel(Naam, Type, Voorraad, Prijs) VALUES(?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, onderdeelIn.getNaam());
			preparedStmt.setString(2, onderdeelIn.getType());
			preparedStmt.setInt(3, onderdeelIn.getVoorraad());
			preparedStmt.setDouble(4, onderdeelIn.getPrijs());
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
}
