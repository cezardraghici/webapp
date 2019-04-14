package accountSelection;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import client.Client;
import client.ClientData;
import connectionDB.ConnectionDB;

public class SearchIntoDB {
	Connection conn = (Connection) ConnectionDB.getCon1();
	
	public Client SetClient(String CIC) {
		ResultSet rs;
		PreparedStatement ps;
		Client c = new Client();
		try {
			
			ps = (PreparedStatement) conn.clientPrepareStatement("Select * from customerdb.clienti where id_client = ?");
			ps.setString(1, CIC);
			rs = ps.executeQuery();
			if (rs.next()) {
				c.setId_client(rs.getString("id_client"));
				c.setNume(rs.getString("nume"));
				c.setPrenume(rs.getString("prenume"));
				c.setLocalitate(rs.getString("localitate"));
				c.setJudet(rs.getString("judet"));
				c.setCNP(rs.getString("CNP"));
				c.setTelefon(rs.getString("telefon"));
			}
			rs.close();
			ps.close();
			ps = (PreparedStatement) conn.clientPrepareStatement("Select Round(sum(rata_credit + rata_dobanda),2) as dlq from customerdb.rate where id_client=? and rata_platita='NO' and data_scadenta<sysdate();");
			ps.setString(1, CIC);
			rs = ps.executeQuery();
			if (rs.next()) 
				c.setDlq(rs.getString("dlq"));
			rs.close();
			ps.close();
			ps = (PreparedStatement) conn.clientPrepareStatement("Select datediff(sysdate(), min(data_scadenta)) as dpd from customerdb.rate where id_client = ? and rata_platita = 'NO';");
			ps.setString(1, CIC);
			rs = ps.executeQuery();
			if (rs.next()) 
				c.setDpd(rs.getString("dpd"));
			rs.close();
			ps.close();
			ps = (PreparedStatement) conn.clientPrepareStatement("Select round(sum(rata_credit + rata_dobanda),2) as exp from customerdb.rate where id_client = ? and rata_platita = 'NO' group by id_client;");
			ps.setString(1, CIC);
			rs = ps.executeQuery();
			if(rs.next())
				c.setExp(rs.getString("exp"));
			rs.close();
			ps.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return c;
	}
	
	public ArrayList<Client> AllClients() {
		ResultSet rs = null;
		Client c;
		ArrayList<Client> cls = new ArrayList<Client>();
		try {
			PreparedStatement ps = (PreparedStatement) conn.clientPrepareStatement("Select * from customerdb.clienti;");
			rs = ps.executeQuery();
			while (rs.next()) {
				c = new Client();
				c.setId_client(rs.getString("id_client"));
				c.setNume(rs.getString("nume"));
				c.setPrenume(rs.getString("prenume"));
				c.setCNP(rs.getString("CNP"));
				c.setLocalitate(rs.getString("localitate"));
				c.setJudet(rs.getString("judet"));
				c.setTelefon(rs.getString("telefon"));
				cls.add(c);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cls;
	}

	
	public ArrayList<ClientData> SearchClientData(String CIC) {
		ResultSet rs = null;
		ArrayList<ClientData> c = new ArrayList<ClientData>();
		ClientData cd;
		int i = 1;
		
		try {
			PreparedStatement ps = (PreparedStatement) conn.clientPrepareStatement("select a.id_client,a.tip_credit, a.id_credit, a.data_acordare, a.valoare_credit, a.moneda, \r\n" + 
					"Round(sum(b.rata_credit + b.rata_dobanda),2) as dlq, \r\n" + 
					"datediff(sysdate(), min(b.data_scadenta)) as dpd from customerdb.credite as a left join customerdb.rate as b on a.id_credit = b.id_credit where a.id_client=? and b.rata_platita='NO' and b.data_scadenta<sysdate() group by a.id_credit;");
			ps.setString(1, CIC);
			rs = ps.executeQuery();
			while(rs.next()) {
				cd = new ClientData();
				cd.setId_client(rs.getString("id_client"));
				cd.setCredit_id(rs.getString("id_credit"));
				cd.setDate_opened(rs.getString("data_acordare"));
				cd.setLimit(rs.getString("valoare_credit"));
				cd.setCurrency(rs.getString("moneda"));
				cd.setDlq(rs.getString("dlq"));
				cd.setDpd(rs.getString("dpd"));
				cd.setTip_credit(rs.getString("tip_credit"));
				cd.setNo(i);
				c.add(cd);
				i++;
			}
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
		return c;
	}

}
