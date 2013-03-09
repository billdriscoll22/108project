package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.DB;

import frontend.User;

/**
 * Servlet implementation class RequestFriendServlet
 */
@WebServlet("/RequestFriendServlet")
public class RequestFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestFriendServlet() {
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
		String friendToAdd = request.getParameter("target");
		User currentUser = (User)request.getSession().getAttribute("user");
		
		ServletContext context = request.getServletContext();
		DB db = (DB) context.getAttribute("db");
		
		db.sendFriendRequest(currentUser.getID(), friendToAdd);
		
		request.getRequestDispatcher("/request_friend.jsp").forward(request, response);
	}

}
