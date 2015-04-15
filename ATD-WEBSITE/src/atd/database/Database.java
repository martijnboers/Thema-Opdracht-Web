package atd.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Database {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static String url = "jdbc:mysql://db.plebian.nl:3306/autototaaldienst";
	private static String user = "atd";
	private static String password = "AutoTotaalDienst"; // VERANDER DIT

	private static Properties prop = new Properties();
	private static InputStream config = null;

	public static void main(String[] args) {
		sqlQuery("SELECT VERSION()");
	}

	public static boolean sqlQuery(String input) {
		try {
			config = new FileInputStream("config/database.properties");
			prop.load(config);
			con = DriverManager.getConnection("jdbc:mysql://" + prop.getProperty("database") + ":3306/" + prop.getProperty("table"),
					prop.getProperty("dbuser"), prop.getProperty("dbpassword"));
			st = con.createStatement();
			rs = st.executeQuery(input);

			if (rs.next()) {
				System.out.println(rs.getString(1));
			}

		} catch (SQLException | IOException ex) {
			System.out.println(ex.getMessage());
			return false;
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
				return false;
			}
		}
		return true;
	}
}
