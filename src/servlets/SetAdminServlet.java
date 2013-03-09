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
 * Servlet implementation class ToggleAdminServlet
 */
@WebServlet("/SetAdminServlet")
public class SetAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		DB db = (DB) context.getAttribute("db");
		
		String user = request.getParameter("target");
		boolean value = request.getParameter("bool").equals("true") ? true : false;
		db.setAdminStatus(user, value);
		
		
		
		request.getRequestDispatcher("/set_admin.jsp").forward(request, response);
	}

}
