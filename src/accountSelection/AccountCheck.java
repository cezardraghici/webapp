package accountSelection;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.Client;
import client.ClientData;
import user.UserLog;


@WebServlet ("/AccountCheck")
public class AccountCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AccountCheck() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String submitType = request.getParameter("submit");
		String CIC = request.getParameter("cic");
		String CNP = request.getParameter("cnp");
		String userName = request.getParameter("user");
		UserLog user = new UserLog();
		user.setUser(userName);
		
		CheckDB c = new CheckDB();
		String g = c.SearchCNP(CNP);
		ArrayList<ClientData> clientD = new ArrayList<ClientData>();
		Client customer = new Client();
		SearchIntoDB d = new SearchIntoDB();
		
		
		if (submitType.equals("Search")) {
			if (c.CheckCIC(CIC) == 1) {
				customer = d.SetClient(CIC);
				clientD = d.SearchClientData(CIC);
				request.setAttribute("customer", customer);
				request.setAttribute("clientD", clientD);
				request.setAttribute("user", user);
				request.getRequestDispatcher("WEB-INF/clientInfo.jsp").forward(request, response);
			}
			else if (c.CheckCNP(CNP) == 1) {
				
				customer = d.SetClient(g);
				clientD = d.SearchClientData(g);
				request.setAttribute("customer", customer);
				request.setAttribute("clientD", clientD);
				request.setAttribute("user", user);
				request.getRequestDispatcher("WEB-INF/clientInfo.jsp").forward(request, response);
			}
			else {
				request.setAttribute("errorCICFound", "Clientul nu este in baza de date");
				request.setAttribute("user", user);
				request.getRequestDispatcher("WEB-INF/accountSelection.jsp").forward(request, response);
			}
			
		}
		
		
		
	}

}
