package clientInfo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accountSelection.SearchIntoDB;
import client.Client;
import client.ClientData;
import user.UserLog;


@WebServlet("/ClientDiary")
public class ClientDiary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ClientDiary() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String CIC = request.getParameter("CIC");
		String submit = request.getParameter("submit");
		String userName = request.getParameter("user");
		UserLog user = new UserLog();
		user.setUser(userName);
		ArrayList<ClientData> clientD = new ArrayList<ClientData>();
		Client customer = new Client();
		SearchIntoDB d = new SearchIntoDB();
		DB db = new DB();
		
		if (submit.equals("Back")) {
			customer = d.SetClient(CIC);
			clientD = d.SearchClientData(CIC);
			request.setAttribute("customer", customer);
			request.setAttribute("clientD", clientD);
			request.setAttribute("user", user);
			request.getRequestDispatcher("WEB-INF/clientInfo.jsp").forward(request, response);
			
		}
		else if (submit.equals("Add Diary")) {
			customer = d.SetClient(CIC);
			clientD = d.SearchClientData(CIC);
			request.setAttribute("user", user);
			request.setAttribute("customer", customer);
			request.setAttribute("clientD", clientD);
			request.getRequestDispatcher("WEB-INF/addDiary1.jsp").forward(request, response);
		}
		else if (submit.equals("Client Diary")) {
			ArrayList<DiaryInfo> di = new ArrayList<DiaryInfo>();
			di = db.setDiary(CIC);
			customer = d.SetClient(CIC);
			clientD = d.SearchClientData(CIC);
			request.setAttribute("di", di);
			request.setAttribute("user", user);
			request.setAttribute("customer", customer);
			request.setAttribute("clientD", clientD);
			request.getRequestDispatcher("WEB-INF/clientDiary1.jsp").forward(request, response);
		}
	}

}
