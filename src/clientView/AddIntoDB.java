package clientView;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connectionDB.ConnectionDB;

public class AddIntoDB {
	
	Connection conn;
	
	public void InsertIntoDB(String nume, String prenume, String CNP, String localitate, String judet, String telefon) {
		
		try {
			conn = (Connection) ConnectionDB.getCon1();
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("insert into customerdb.clienti (`nume`, `prenume`, `CNP`, `localitate`, `judet`, `telefon`) values (?,?,?,?,?,?);");
			ps.setString(1, nume);
			ps.setString(2, prenume);
			ps.setString(3, CNP);
			ps.setString(4, localitate);
			ps.setString(5, judet);
			ps.setString(6, telefon);
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
