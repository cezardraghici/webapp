package clientInfo;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connectionDB.ConnectionDB;

public class DB {
	Connection conn = (Connection) ConnectionDB.getCon();
	
	public void InsertIntoDB(String user, String id_client, String action, String diary) {
		
		try {
			PreparedStatement ps;
			ps = (PreparedStatement) conn.prepareStatement("insert into actions (`user`,`id_client`,`action_type`,`action_description`,"
					+ "`action_date`,`action_time`) values(?,?,?,?,CURRENT_DATE(),CURRENT_TIME());");
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
			PreparedStatement ps = (PreparedStatement) conn.clientPrepareStatement("select user, action_type,action_description, action_date, action_time from actions where id_client=? order by action_date, action_time desc;");
			ps.setString(1, CIC);
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				d = new DiaryInfo();
				d.setUser(rs.getString("user"));
				d.setAction(rs.getString("action_type"));
				d.setActiondes(rs.getString("action_description"));
				d.setDate(rs.getString("action_date"));
				d.setTime(rs.getString("action_time"));
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
