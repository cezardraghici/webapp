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
import user.UserLog;


@WebServlet("/ClientInfo")
public class ClientInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ClientInfo() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String submit = request.getParameter("submit");
		String CIC = request.getParameter("CIC");
		String userName = request.getParameter("user");
		UserLog user = new UserLog();
		user.setUser(userName);
		
		Client customer = new Client();
		SearchIntoDB d = new SearchIntoDB();
		DB db = new DB();
		customer = d.SetClient(CIC);
		
		if (submit.equals("Add Diary")) {
			request.setAttribute("user", user);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("WEB-INF/addDiary.jsp").forward(request, response);
		}
		else if (submit.equals("Client Diary")) {
			ArrayList<DiaryInfo> di = new ArrayList<DiaryInfo>();
			di = db.setDiary(CIC);
			request.setAttribute("di", di);
			request.setAttribute("user", user);
			request.getRequestDispatcher("WEB-INF/clientDiary.jsp").forward(request, response);
		}
		
	}
		
		

}
