package atd.database;

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

import atd.domein.Afspraak;
import atd.domein.StatusDB;

/**
 * @author Martijn
 *
 */

public class AfspraakDAO {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static Properties prop = new Properties();
	private static InputStream config = null;
	
	private static final String CONFIG_URL = "http://localhost:8080/ATD-WEBSITE/config/database.properties";

	public static StatusDB setAfspraak(Afspraak afspraak) {
		try {
			config = new URL(CONFIG_URL).openStream();
			prop.load(config);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("host") + ":3306/" + prop.getProperty("database"), prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();

			String query = "INSERT INTO Afspraak(Klant, Monteur, Auto, Datum, Omschrijving) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, afspraak.getKlant().getId());
			preparedStmt.setInt(2, afspraak.getMonteur().getId());
			preparedStmt.setInt(1, afspraak.getAuto().getId());
			preparedStmt.setDate(1, afspraak.getDatum());
			preparedStmt.setInt(1, afspraak.getKlant().getId());			
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