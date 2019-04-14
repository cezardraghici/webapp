package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

	static Connection conn = null;
	static String username = "cezar";
	static String password = "Guesswho13";
	static String url1 = "jdbc:mysql://localhost:3306/login?useSSL=false";
	static String url2 = "jdbc:mysql://localhost:3306/customerdb?useSSL=false";

	public static Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url1, username, password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}

	public static Connection getCon1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url2, username, password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}

}
