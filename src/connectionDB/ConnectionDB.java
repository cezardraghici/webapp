package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

	static Connection conn = null;
	static String username = "root";
	static String password = "Oaltazi13";
	static String url1 = "jdbc:mysql://localhost:3306/mydb?useSSL=false";


	public static Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url1, username, password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
}
