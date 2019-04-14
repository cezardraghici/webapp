package userLoginAndRegistration;

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


@WebServlet("/MainCheck")
public class MainCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MainCheck() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("user");
		UserLog user = new UserLog();
		user.setUser(userName);
		String submitType = request.getParameter("submit");
		if (submitType.equals("Log out")) {
			request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
		}
		else if (submitType.equals("Account Selection")) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("WEB-INF/accountSelection.jsp").forward(request, response);
		}
		else if (submitType.equals("Clients View")){
			request.setAttribute("user", user);
			SearchIntoDB d = new SearchIntoDB();
			ArrayList<Client> customer = new ArrayList<Client>();
			customer = d.AllClients();
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("WEB-INF/clientView.jsp").forward(request, response);
		}
	}

}
