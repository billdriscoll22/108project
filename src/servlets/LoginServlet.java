package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import frontend.Hash;
import frontend.User;

import sql.DB;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		DB db = (DB) context.getAttribute("db");
	
		String id = request.getParameter("username");
		String password = request.getParameter("password");
		User user = db.getUser(id);
		
		// check credentials
		if(user != null && Hash.checkPassword(password, user.getHash())){
			// set session user object
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			// forward to welcome page
			RequestDispatcher dispatch = request.getRequestDispatcher("HomeServlet");
			dispatch.forward(request, response);
		} else {
			// forward to incorrect info page
			RequestDispatcher dispatch = request.getRequestDispatcher("bad_login_credentials.html");
			dispatch.forward(request, response);
		}
	}

}
