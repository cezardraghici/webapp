package accountSelection;

import java.sql.ResultSet;
import java.util.LinkedList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connectionDB.ConnectionDB;

public class CheckDB {
	Connection conn = (Connection) ConnectionDB.getCon1();
	
	public int CheckCIC(String c) {
		int i = 0;
		PreparedStatement a;
		ResultSet rs;
		String u = null;
		
		try {
			a = (PreparedStatement) conn.prepareStatement("select id_client from customerDB.clienti;");
			rs  =a.executeQuery();
			while (rs.next()) {
				u = rs.getString("id_client");
				if (c.equals(u)) {
					i = 1;
					break;
				}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return i;
	}
	
	public int CheckCNP(String c) {
		int i = 0;
		PreparedStatement a;
		ResultSet rs;
		String u = null;
		
		try {
			a = (PreparedStatement) conn.prepareStatement("select CNP from customerDB.clienti;");
			rs  =a.executeQuery();
			while (rs.next()) {
				u = rs.getString("CNP");
				if (c.equals(u)) {
					i = 1;
					break;
				}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return i;
	}
	
	public String SearchCNP(String c) {
		String id = null;
		PreparedStatement a;
		ResultSet rs;
		try {
			a = (PreparedStatement) conn.prepareStatement("select id_client from customerDB.clienti where CNP=?;");
			a.setString(1, c);
			rs  =a.executeQuery();
			if (rs.next()) {
				id = rs.getString("id_client");
				}
			}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return id;
	}
	
	public LinkedList<String> AllCIC() {
		LinkedList<String> list = new LinkedList<String>();
		PreparedStatement a;
		ResultSet rs;
		try {
			a = (PreparedStatement) conn.prepareStatement("select id_client from customerDB.clienti;");
			rs  =a.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("id_client"));
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return list;
	}
}
