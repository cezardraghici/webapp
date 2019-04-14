package userLoginAndRegistration;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import connectionDB.ConnectionDB;

public class InsertInDB {

	public void InsertIntoDB(String user, String password, String firstName, String lastName, String email,
			String adress, String phone) {

		try {
			Connection conn = ConnectionDB.getCon();
			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement("INSERT INTO login.userlogin values(?,?,?,?,?,?,?,?);");
			ps.setString(1, user);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, email);
			ps.setString(6, adress);
			ps.setString(7, phone);
			ps.setString(8, "user");
			ps.executeUpdate();

			conn.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	public int CheckNull(String user, String password, String firstName, String lastName, String email, String adress,
			String phone) {
		int n = 0;
		if (user.length() > 1 && password.length() > 1 && firstName.length() > 1 && lastName.length() > 1
				&& adress.length() > 1 && phone.length() > 1)
			n = 1;

		return n;
	}
}
