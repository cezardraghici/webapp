package clientView;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connectionDB.ConnectionDB;

public class RemoveFromDB {

	Connection conn;
	
	public void RemoveClient(String CIC) {
		
		
		PreparedStatement ps;
		try {
			conn  = (Connection) ConnectionDB.getCon1();
			ps = (PreparedStatement) conn.prepareStatement("delete from customerDB.clienti where id_client=?;");
			ps.setString(1, CIC);
			ps.executeUpdate();
			
			conn.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
