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


@WebServlet("/ClientEdit")
public class ClientEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ClientEdit() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nume = request.getParameter("nume");
		String prenume = request.getParameter("prenume");
		String localitate = request.getParameter("localitate");
		String judet = request.getParameter("judet");
		String telefon = request.getParameter("telefon");
		String submit = request.getParameter("submit");
		String CIC = request.getParameter("CIC");
		String userName = request.getParameter("user");
		EditDB c = new EditDB();
		UserLog user = new UserLog();
		user.setUser(userName);
		
		if(submit.equals("Submit")) {
			c.upDB(nume, prenume, localitate, judet, telefon, CIC);
			SearchIntoDB d = new SearchIntoDB();
			ArrayList<Client> customer = new ArrayList<Client>();
			customer = d.AllClients();
			request.setAttribute("customers", customer);
			request.setAttribute("user", user);
			request.getRequestDispatcher("WEB-INF/clientView.jsp").forward(request, response);
		}
		
	}

}
