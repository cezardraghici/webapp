package clientView;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accountSelection.SearchIntoDB;
import client.Client;
import user.UserLog;


@WebServlet("/AddClient")
public class AddClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AddClient() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String submit = request.getParameter("submit");
		String nume = request.getParameter("nume");
		String prenume = request.getParameter("prenume");
		String CNP = request.getParameter("CNP");
		String localitate = request.getParameter("localitate");
		String judet = request.getParameter("judet");
		String telefon = request.getParameter("telefon");
		String userName = request.getParameter("user");
		EditDB ad = new EditDB();
		UserLog user = new UserLog();
		user.setUser(userName);
		
		if (submit.equals("Submit")) {
			ad.InsertIntoDB(nume, prenume, CNP, localitate, judet, telefon);
			SearchIntoDB d = new SearchIntoDB();
			ArrayList<Client> customer = new ArrayList<Client>();
			customer = d.AllClients();
			request.setAttribute("customer", customer);
			request.setAttribute("user", user);
			request.getRequestDispatcher("WEB-INF/clientView.jsp").forward(request, response);
		}
	}
}
