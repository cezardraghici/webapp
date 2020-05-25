package clientView;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accountSelection.CheckDB;
import accountSelection.SearchIntoDB;
import client.Client;
import user.UserLog;

@WebServlet("/ClientView")
public class ClientView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClientView() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EditDB rm = new EditDB();
		String CIC = "null";
		String submit = request.getParameter("submit");
		CIC = request.getParameter("CIC");
		String userName = request.getParameter("user");
		UserLog user = new UserLog();
		user.setUser(userName);
		ArrayList<Client> customer = new ArrayList<Client>();
		SearchIntoDB d = new SearchIntoDB();
		customer = d.AllClients();
		Client clientD = new Client();
		clientD = d.SetClient(CIC);
		CheckDB c = new CheckDB();
		
		if (submit.equals("Add Client")) {
			request.setAttribute("clientD", clientD);
			request.setAttribute("user", user);
			request.getRequestDispatcher("WEB-INF/addClient.jsp").forward(request, response);
		} else if (submit.equals("Remove Client")) {
			rm.RemoveClient(CIC);
			request.setAttribute("customers", customer);
			request.setAttribute("user", user);
			request.getRequestDispatcher("WEB-INF/clientView.jsp").forward(request, response);
		} else if (submit.equals("Edit Client")) {
			if (c.CheckCIC(CIC) == 1) {
				request.setAttribute("user", user);
				request.setAttribute("clientD", clientD);
				request.getRequestDispatcher("WEB-INF/clientEdit.jsp").forward(request, response);
			} else {
				request.setAttribute("customers", customer);
				request.setAttribute("user", user);
				request.setAttribute("message", "Please select a client first!");
				request.getRequestDispatcher("WEB-INF/clientView.jsp").forward(request, response);
			}
		} else if (submit.equals("Add Credit")) {
			if (c.CheckCIC(CIC) == 1) {
				request.setAttribute("user", user);
				request.setAttribute("clientD", clientD);
				request.getRequestDispatcher("WEB-INF/addCredit.jsp").forward(request, response);
			} else {
				request.setAttribute("customers", customer);
				request.setAttribute("user", user);
				request.setAttribute("message", "Please select a client first!");
				request.getRequestDispatcher("WEB-INF/clientView.jsp").forward(request, response);
			}
		} else if (submit.equals("Add Payment")) {
			if (c.CheckCIC(CIC) == 1) {
				request.setAttribute("clinetD", clientD);
				request.setAttribute("customers", customer);
				request.setAttribute("user", user);
				request.getRequestDispatcher("WEB-INF/addPayment.jsp").forward(request, response);
			} else {
				request.setAttribute("customers", customer);
				request.setAttribute("user", user);
				request.setAttribute("message", "Please select a client first!");
				request.getRequestDispatcher("WEB-INF/clientView.jsp").forward(request, response);
			}
		} else if (submit.equals("Log out")) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}
}
