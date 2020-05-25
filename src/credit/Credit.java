package credit;

import java.time.LocalDate;

public class Credit {

	private String period;
	private String percent;
	private String amount;
	private String payment_rate;
	private LocalDate grant_date;
	private LocalDate end_date;
	private LocalDate due_date;
	private String currency;
	private String payment_rate_number;
	private String loan_rate;
	private String interest_rate;
	private String rate_paid;
	private String loan_type;
	private String day;
	private String id_client;
	private String id_loan;

	
	public String getId_loan() {
		return id_loan;
	}
	public void setId_loan(String id_loan) {
		this.id_loan = id_loan;
	}
	public String getId_client() {
		return id_client;
	}
	public void setId_client(String id_client) {
		this.id_client = id_client;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getLoan_type() {
		return loan_type;
	}
	public void setLoan_type(String loan_type) {
		this.loan_type = loan_type;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPayment_rate() {
		return payment_rate;
	}
	public void setPayment_rate(String payment_rate) {
		this.payment_rate = payment_rate;
	}
	
	public LocalDate getGrant_date() {
		return grant_date;
	}
	public void setGrant_date(LocalDate grant_date) {
		this.grant_date = grant_date;
	}
	
	public LocalDate getEnd_date() {
		return end_date;
	}
	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
	public LocalDate getDue_date() {
		return due_date;
	}
	public void setDue_date(LocalDate due_date) {
		this.due_date = due_date;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPayment_rate_number() {
		return payment_rate_number;
	}
	public void setPayment_rate_number(String payment_rate_number) {
		this.payment_rate_number = payment_rate_number;
	}
	public String getLoan_rate() {
		return loan_rate;
	}
	public void setLoan_rate(String loan_rate) {
		this.loan_rate = loan_rate;
	}
	public String getInterest_rate() {
		return interest_rate;
	}
	public void setInterest_rate(String interest_rate) {
		this.interest_rate = interest_rate;
	}
	public String getRate_paid() {
		return rate_paid;
	}
	public void setRate_paid(String rate_paid) {
		this.rate_paid = rate_paid;
	}
	
	
	
	
	
}
