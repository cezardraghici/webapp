package userLoginAndRegistration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class RegisterCheck
 */
@WebServlet("/RegisterCheck")
public class RegisterCheck extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InsertInDB n = new InsertInDB();
		UserCheck c = new UserCheck();
		
		
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String adress = request.getParameter("adress");
		String phone = request.getParameter("phone");
		String submitType = request.getParameter("submit");
		int y = c.UserCheckIfExist(user);
	
		try {
			if (submitType.equals("Register")) {
				if (y == 1) {
					request.setAttribute("userError", "User already exist! Please select another user!");
					request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
				} else {
					n.InsertIntoDB(user, password, firstName, lastName, email, adress, phone);
					request.setAttribute("succesMessage", "User created, please login!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			else
				request.setAttribute("errorMessage", "You must fill all fields!");
			request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
 		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
