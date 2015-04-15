package atd.database;

import java.sql.*;

public class Database {
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	private static String url = "jdbc:mysql://db.plebian.nl:3306/autototaaldienst";
	private static String user = "atd";
	private static String password = "wachtwoord"; // VERANDER DIT
	
	public static void main(String[] args) {
		sqlQuery("SELECT VERSION()");
	}
	public static boolean sqlQuery(String input){
		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery(input);

			if (rs.next()) {
				System.out.println(rs.getString(1));
			}

		} catch (SQLException ex) {
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
