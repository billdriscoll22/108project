package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frontend.User;

import sql.DB;

/**
 * Servlet implementation class UserHistoryServlet
 */
@WebServlet("/UserHistoryServlet")
public class UserHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHistoryServlet() {
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

		// pass database
		ServletContext context = request.getServletContext();
		DB db = (DB) context.getAttribute("db");
		request.setAttribute("db", db);
		
		// pass target user to display
		String targetID = request.getParameter("target");
		User target = db.getUser(targetID);
		request.setAttribute("target", target);		
		
		request.getRequestDispatcher("/user_history.jsp").forward(request, response);	
	}

}
