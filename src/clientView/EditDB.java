package clientView;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connectionDB.ConnectionDB;

public class EditDB {
	Connection conn = (Connection) ConnectionDB.getCon();

	public void upNume(String nume, String CIC) {

		try {
			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement("update clients set firstname=? where id_client=?;");
			ps.setString(1, nume);
			ps.setString(2, CIC);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void upPrenume(String prenume, String CIC) {

		try {
			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement("update clients set lastname=? where id_client=?;");
			ps.setString(1, prenume);
			ps.setString(2, CIC);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void upLocalitate(String localitate, String CIC) {

		try {
			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement("update clients set city=? where id_client=?;");
			ps.setString(1, localitate);
			ps.setString(2, CIC);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void upJudet(String judet, String CIC) {

		try {
			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement("update clients set region=? where id_client=?;");
			ps.setString(1, judet);
			ps.setString(2, CIC);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void upTelefon(String telefon, String CIC) {

		try {
			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement("update clients set phone=? where id_client=?;");
			ps.setString(1, telefon);
			ps.setString(2, CIC);
			ps.executeUpdate();
		} catch (Exception e) {
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

	public void InsertIntoDB(String nume, String prenume, String CNP, String localitate, String judet, String telefon) {

		try {
			conn = (Connection) ConnectionDB.getCon();
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(
					"insert into clients (`firstname`,`lastname`, `CNP`, `city`, `region`, `phone`) values (?,?,?,?,?,?);");
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

	public void RemoveClient(String CIC) {

		PreparedStatement ps;
		try {
			conn = (Connection) ConnectionDB.getCon();
			ps = (PreparedStatement) conn.prepareStatement("delete from clients where id_client=?;");
			ps.setString(1, CIC);
			ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
