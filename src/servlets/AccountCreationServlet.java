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
 * Servlet implementation class AccountCreationServlet
 */
@WebServlet("/AccountCreationServlet")
public class AccountCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountCreationServlet() {
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
		System.out.println("hitting account creation servlet post");
		ServletContext context = request.getServletContext();
		DB db = (DB) context.getAttribute("db");
	
		String id = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(db.getUser(id) != null){
			// forward to account name in use page
			RequestDispatcher dispatch = request.getRequestDispatcher("username_in_use.jsp");
			dispatch.forward(request, response);
			
		} else {
			String imageURL = request.getParameter("profileImage");
			if(imageURL == "Image URL") {
				// add new user to database
				String hash = Hash.getHash(password);
				String defaultUserImage = "http://stanfordflipside.com/images/139not.png";
				
				db.addUser(id, hash, false, defaultUserImage);
				
				// set session user object
				HttpSession session = request.getSession();
				session.setAttribute("user", new User(id, hash, false, db, defaultUserImage));
			} else {
				// add new user to database
				String hash = Hash.getHash(password);
				db.addUser(id, hash, false, imageURL);
				
				// set session user object
				HttpSession session = request.getSession();
				session.setAttribute("user", new User(id, hash, false, db, imageURL));
			}
			
			// forward to home page
			RequestDispatcher dispatch = request.getRequestDispatcher("/HomeServlet");
			dispatch.forward(request, response);
		}
	}

}
