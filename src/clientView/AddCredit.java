package clientView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accountSelection.SearchIntoDB;
import client.Client;
import credit.Credit;
import credit.CreditCalc;
import user.UserLog;

@WebServlet("/AddCredit")
public class AddCredit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddCredit() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CIC = request.getParameter("CIC");
		String suma = request.getParameter("suma");
		String perioada = request.getParameter("perioada");
		String dobanda = request.getParameter("dobanda");
		String scadenta = request.getParameter("scadenta");
		String submit = request.getParameter("submit");
		String userName = request.getParameter("user");
		
		CreditCalc cr = new CreditCalc();
		Credit c = new Credit();
		LocalDate localDate = LocalDate.parse(scadenta);
		UserLog user = new UserLog();
		user.setUser(userName);
		SearchIntoDB d = new SearchIntoDB();
		ArrayList<Client> customer = new ArrayList<Client>();
		customer = d.AllClients();
		ArrayList<Credit> scd = new ArrayList<Credit>();
		Client clientD = new Client();
		clientD = d.SetClient(CIC);
		
		
		if (submit.equals("Submit")) {
			c= cr.setCredit(suma, dobanda, perioada, localDate, CIC);
		//	cr.insertCredit(suma, dobanda, perioada, localDate, CIC);
			cr.insetPaymentRate(suma, dobanda, perioada, localDate, CIC);
			System.out.println(c.getId_loan());
			request.setAttribute("customers", customer);
			request.setAttribute("user", user);
			request.getRequestDispatcher("WEB-INF/clientView.jsp").forward(request, response);
		}
		else if (submit.equals("Calculeaza rata")) {
			c= cr.setCredit(suma, dobanda, perioada, localDate, CIC);
			System.out.println(c.getId_loan());
			scd = cr.scadentar(suma, dobanda, perioada, localDate, CIC);
			request.setAttribute("suma", suma);
			request.setAttribute("perioada", perioada);
			request.setAttribute("scadenta", scadenta);
			request.setAttribute("scd", scd);
			request.setAttribute("clientD", clientD);
			request.setAttribute("user", user);
			request.getRequestDispatcher("WEB-INF/calcRate.jsp").forward(request, response);
		}
	}

}
