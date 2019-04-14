package userLoginAndRegistration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.UserLog;

@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserLog user = new UserLog();
		UserCheck c = new UserCheck();
		String userName = request.getParameter("user");
		String password = request.getParameter("password");
		String submit = request.getParameter("submit");
		user.setUser(userName);
		
		if (submit.equals("login")) {
			int i = c.Check(userName, password);
			if (i == 1) {
				
				request.setAttribute("user", user);
				request.getRequestDispatcher("WEB-INF/main.jsp").forward(request, response);

			} else if (i == 0 | userName.equals("") | password.equals("")) {
				request.setAttribute("message", "User Not Found, please register first!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else if (submit.equals("Register")) {

			request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
		}
	}

}
