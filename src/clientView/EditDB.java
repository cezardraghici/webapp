package clientView;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connectionDB.ConnectionDB;

public class EditDB {
	Connection conn = (Connection) ConnectionDB.getCon1();
	
	public void upNume (String nume, String CIC) {
		
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("update customerdb.clienti set nume=? where id_client=?;");
			ps.setString(1, nume);
			ps.setString(2, CIC);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void upPrenume (String prenume, String CIC) {
		
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("update customerdb.clienti set prenume=? where id_client=?;");
			ps.setString(1, prenume);
			ps.setString(2, CIC);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void upLocalitate (String localitate, String CIC) {
		
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("update customerdb.clienti set localitate=? where id_client=?;");
			ps.setString(1, localitate);
			ps.setString(2, CIC);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void upJudet (String judet, String CIC) {
		
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("update customerdb.clienti set judet=? where id_client=?;");
			ps.setString(1, judet);
			ps.setString(2, CIC);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void upTelefon (String telefon, String CIC) {
		
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("update customerdb.clienti set telefon=? where id_client=?;");
			ps.setString(1, telefon);
			ps.setString(2, CIC);
			ps.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void upDB(String nume, String prenume, String localitate, String judet, String telefon, String CIC) {
		
		if (nume != "")
			upNume(nume, CIC);
		if (prenume != "")
			upPrenume(prenume, CIC);
		if (localitate != "")
			upLocalitate(localitate, CIC);
		if (judet != "")
			upJudet(judet, CIC);
		if (telefon != "")
			upTelefon(telefon, CIC);
	}
}
