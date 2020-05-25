package userLoginAndRegistration;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import connectionDB.ConnectionDB;

public class UserCheck {

	String u = null;
	String p = null;
	Connection conn = ConnectionDB.getCon();

	public void set(String user) {

		PreparedStatement a;
		ResultSet rs;

		try {

			a = (PreparedStatement) conn.prepareStatement("select user, password from user_login where user=?;");
			a.setString(1, user);
			rs = a.executeQuery();

			if (rs.next()) {
				u = rs.getString("user");
				p = rs.getString("password");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int Check(String userName, String password1) {
		int s = 0;
		set(userName);
		if (userName.equals(u) && password1.equals(p))
			s = 1;

		return s;
	}

	public int UserCheckIfExist(String userName) {
		int i = 0;
		PreparedStatement a;
		ResultSet rs;
		String u = null;

		try {

			a = (PreparedStatement) conn.prepareStatement("select user from mydb.user_login;");
			rs = a.executeQuery();
			while (rs.next()) {
				u = rs.getString("user");
				if (userName.equals(u))
					i = 1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return i;
	}
}
