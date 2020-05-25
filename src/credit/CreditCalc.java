package credit;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connectionDB.ConnectionDB;

public class CreditCalc {
	Connection conn = (Connection) ConnectionDB.getCon();

	public double interestCalc(double amount, double percent, double period) {
		double interest;
		interest = amount * Math.pow((1 + percent / 100), period / 12) - amount;
		interest = interest / period;
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.parseDouble(df.format(interest));
	}

	public double paymentRate(double amount, double percent, double period) {
		double rate;
		double interest = interestCalc(amount, percent, period);
		rate = amount / period + interest;
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.parseDouble(df.format(rate));
	}
	


	public Credit setCredit(String amount, String percent, String period, LocalDate date, String id_client) {
		Credit cr = new Credit();
		
		double payment_rate = paymentRate(Double.parseDouble(amount), Double.parseDouble(percent),
				Double.parseDouble(period));
		double interest = interestCalc(Double.parseDouble(amount), Double.parseDouble(percent),
				Double.parseDouble(period));
		double loan_rate = Double.parseDouble(amount) / Double.parseDouble(period);
		int nr = 0;
		LocalDate currentDay = LocalDate.now();
		DecimalFormat df = new DecimalFormat("0.00");
		if (currentDay.isBefore(date)) {
			nr = Integer.valueOf(period) - 1;
		} else if (currentDay.isAfter(date)) {
			nr = Integer.valueOf(period);
		}
		cr.setAmount(amount);
		cr.setPercent(percent);
		cr.setPeriod(period);
		cr.setLoan_type("CRD");
		cr.setPayment_rate(String.valueOf(df.format(payment_rate)));
		cr.setGrant_date(currentDay);
		cr.setEnd_date(date.plusMonths(nr));
		cr.setDue_date(date);
		cr.setCurrency("RON");
		cr.setInterest_rate(String.valueOf(df.format(interest)));
		cr.setLoan_rate(String.valueOf(df.format(loan_rate)));
		cr.setRate_paid("NO");
		cr.setDay(String.valueOf(date.getDayOfMonth()));
		cr.setId_client(id_client);
		
		return cr;
	}

	public void insertCredit(String amount, String percent, String period, LocalDate date, String id_client) {
		Credit cr = new Credit();
		cr = setCredit(amount, percent, period, date, id_client);
		try {
			conn = (Connection) ConnectionDB.getCon();
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(
					"insert into loans (`id_client`,`loan_type`,`loan_amount`,`payment_rate`,`period`,`grant_date`,`end_date`,`due_date`,`percent`,`currency`) values (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, cr.getId_client());
			ps.setString(2, cr.getLoan_type());
			ps.setString(3, cr.getAmount());
			ps.setString(4, cr.getPayment_rate());
			ps.setString(5, cr.getPeriod());
			ps.setString(6, cr.getGrant_date().toString());
			ps.setString(7, cr.getEnd_date().toString());
			ps.setString(8, cr.getDay());
			ps.setString(9, cr.getPercent());
			ps.setString(10, cr.getCurrency());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String idLoan(String amount, String percent, String period, LocalDate date, String id_client) {
		String id_loan = null;
		LocalDate crdate = LocalDate.now();
		try {
			conn = (Connection) ConnectionDB.getCon();
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(
					"select id_loan from loans where id_client=? and period=? and loan_amount=? and grant_date=?");
				ps.setString(1, id_client);
				ps.setString(2, period);
				ps.setString(3, amount);
				ps.setString(4, crdate.toString());
			ResultSet rs = ps.executeQuery();
			rs.beforeFirst();
			rs.next();
			id_loan = rs.getString("id_loan");
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	 return id_loan;
	}

	public ArrayList<Credit> scadentar(String amount, String percent, String period, LocalDate date, String id_client) {
		ArrayList<Credit> scd = new ArrayList<Credit>();
		Credit cr = new Credit();
		

		DecimalFormat df = new DecimalFormat("0.00");
		double am = Double.parseDouble(amount);
		int i = Integer.parseInt(period);
		int n = 1;
		while (i > 0) {
			cr = setCredit(amount, percent, period, date, id_client);
			if (n == Integer.parseUnsignedInt(period)) {
				cr.setLoan_rate(String.valueOf(df.format(am)));
				cr.setPayment_rate(df.format(am + Double.parseDouble(cr.getInterest_rate())));
			}
			am = am - Double.valueOf(cr.getLoan_rate());
			cr.setAmount(String.valueOf(df.format(am)));

			cr.setPayment_rate_number(String.valueOf(n));
			scd.add(cr);
			i--;
			n++;
			date = date.plusMonths(1);

		}
		return scd;
	}

	public void insetPaymentRate(String amount, String percent, String period, LocalDate date, String id_client) {
		insertCredit(amount, percent, period, date, id_client);
		
		ArrayList<Credit> scd = new ArrayList<Credit>();
		scd = scadentar(amount, percent, period, date, id_client);
		String id_loan = String.valueOf(idLoan(amount, percent, period, date, id_client));
	
		System.out.println(id_loan);
		int i = 0;
		int n = 1;
		try {
			conn = (Connection) ConnectionDB.getCon();
			for ( Credit cr : scd) {
				cr.setId_loan(id_loan);
				cr = scd.get(i);
				PreparedStatement ps = (PreparedStatement) conn.prepareStatement(
						"insert into payment_rate (`id_client`, `id_loan`, `payment_rate_number`, `loan_rate`, `interest_rate`, `due_date`, `rate_paid`) values (?,?,?,?,?,?,?);");
				ps.setString(1, id_client);
				ps.setString(2, cr.getId_loan());
				ps.setString(3, String.valueOf(n));
				ps.setString(4, cr.getLoan_rate());
				ps.setString(5, cr.getInterest_rate());
				ps.setString(6, cr.getDue_date().toString());
				ps.setString(7, cr.getRate_paid());
				ps.executeUpdate();
				n++;
				i++;
			}
			System.out.println(id_loan);
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
