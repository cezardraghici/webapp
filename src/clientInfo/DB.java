package clientInfo;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connectionDB.ConnectionDB;

public class DB {
	Connection conn = (Connection) ConnectionDB.getCon1();
	
	public void InsertIntoDB(String user, String id_client, String action, String diary) {
		
		try {
			PreparedStatement ps;
			ps = (PreparedStatement) conn.prepareStatement("insert into customerdb.tip_actiune(`user`,`id_client`,`tip_actiune`,`descriere_actiune`,"
					+ "`data_actiune`,`ora_actiune`) values(?,?,?,?,CURRENT_DATE(),CURRENT_TIME());");
			ps.setString(1, user);
			ps.setString(2, id_client);
			ps.setString(3, action);
			ps.setString(4, diary);
			ps.executeUpdate();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<DiaryInfo> setDiary(String CIC) {
		DiaryInfo d;
		ArrayList<DiaryInfo> di = new ArrayList<DiaryInfo>();
		try {
			int i = 1;
			PreparedStatement ps = (PreparedStatement) conn.clientPrepareStatement("select * from customerdb.tip_actiune where id_client=?;");
			ps.setString(1, CIC);
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				d = new DiaryInfo();
				d.setUser(rs.getString("user"));
				d.setCIC(rs.getString("id_client"));
				d.setAction(rs.getString("tip_actiune"));
				d.setActiondes(rs.getString("descriere_actiune"));
				d.setDate(rs.getString("data_actiune"));
				d.setTime(rs.getString("ora_actiune"));
				d.setNo(i);
				di.add(d);
				i++;
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return di;
	}
}
