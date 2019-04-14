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


@WebServlet("/ClientView")
public class ClientView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClientView() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RemoveFromDB rm = new RemoveFromDB();
		String submit = request.getParameter("submit");
		String CIC = null;
		CIC = request.getParameter("CIC");
		
		if (submit.equals("Add Client")){
			request.getRequestDispatcher("WEB-INF/addClient.jsp").forward(request, response);
		}
		else if (submit.equals("Remove Client")) {
			rm.RemoveClient(CIC);
			SearchIntoDB d = new SearchIntoDB();
			ArrayList<Client> customer = new ArrayList<Client>();
			customer = d.AllClients();
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("WEB-INF/clientView.jsp").forward(request, response);
		}
		else if(submit.equals("Edit Client")) {
			SearchIntoDB d = new SearchIntoDB();
			Client customer = new Client();
			customer = d.SetClient(CIC);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("WEB-INF/clientEdit.jsp").forward(request, response);
		}
		else if(submit.equals("Add Credit")) {
			SearchIntoDB d = new SearchIntoDB();
			Client customer = new Client();
			customer = d.SetClient(CIC);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("WEB-INF/addCredit.jsp").forward(request, response);
		}
	}

}
