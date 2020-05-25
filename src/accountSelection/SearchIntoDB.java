package accountSelection;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import client.Client;
import client.ClientData;
import connectionDB.ConnectionDB;

public class SearchIntoDB {
	Connection conn = (Connection) ConnectionDB.getCon();
	
	public Client SetClient(String CIC) {
		ResultSet rs;
		PreparedStatement ps;
		Client c = new Client();
		try {
			
			ps = (PreparedStatement) conn.clientPrepareStatement("Select * from clients where id_client = ?");
			ps.setString(1, CIC);
			rs = ps.executeQuery();
			if (rs.next()) {
				c.setId_client(rs.getString("id_client"));
				c.setFirstname(rs.getString("firstname"));
				c.setLastname(rs.getString("lastname"));
				c.setCity(rs.getString("city"));
				c.setRegion(rs.getString("region"));
				c.setCNP(rs.getString("CNP"));
				c.setPhone(rs.getString("phone"));
			}
			rs.close();
			ps.close();
			ps = (PreparedStatement) conn.clientPrepareStatement("Select Round(sum(loan_rate + interest_rate),2) as dlq from payment_rate where id_client=? and rate_paid='NO' and due_date<sysdate();");
			ps.setString(1, CIC);
			rs = ps.executeQuery();
			if (rs.next()) 
				c.setDlq(rs.getString("dlq"));
			rs.close();
			ps.close();
			ps = (PreparedStatement) conn.clientPrepareStatement("Select datediff(sysdate(), min(due_date)) as dpd from payment_rate where id_client = ? and rate_paid = 'NO';");
			ps.setString(1, CIC);
			rs = ps.executeQuery();
			if (rs.next()) 
				c.setDpd(rs.getString("dpd"));
			rs.close();
			ps.close();
			ps = (PreparedStatement) conn.clientPrepareStatement("Select round(sum(loan_rate + interest_rate),2) as exp from payment_rate where id_client = ? and rate_paid = 'NO' group by id_client;");
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
			PreparedStatement ps = (PreparedStatement) conn.clientPrepareStatement("Select * from clients;");
			rs = ps.executeQuery();
			while (rs.next()) {
				c = new Client();
				c.setId_client(rs.getString("id_client"));
				c.setFirstname(rs.getString("firstname"));
				c.setLastname(rs.getString("lastname"));
				c.setCNP(rs.getString("CNP"));
				c.setCity(rs.getString("city"));
				c.setRegion(rs.getString("region"));
				c.setPhone(rs.getString("phone"));
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
			PreparedStatement ps = (PreparedStatement) conn.clientPrepareStatement("select a.id_client,a.loan_type, a.id_loan, a.grant_date, a.loan_amount, a.currency, \r\n" + 
					"Round(sum(b.loan_rate + b.interest_rate),2) as dlq, \r\n" + 
					"datediff(sysdate(), min(b.due_date)) as dpd from loans as a left join payment_rate as b on a.id_loan = b.id_loan where a.id_client=? and b.rate_paid='NO' and b.due_date<sysdate() group by a.id_loan;");
			ps.setString(1, CIC);
			rs = ps.executeQuery();
			while(rs.next()) {
				cd = new ClientData();
				cd.setId_client(rs.getString("id_client"));
				cd.setId_loan(rs.getString("id_loan"));
				cd.setGrant_date(rs.getString("grant_date"));
				cd.setLoan_amount(rs.getString("loan_amount"));
				cd.setCurrency(rs.getString("currency"));
				cd.setDlq(rs.getString("dlq"));
				cd.setDpd(rs.getString("dpd"));
				cd.setLoan_type(rs.getString("loan_type"));
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
