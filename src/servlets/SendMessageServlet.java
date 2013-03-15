package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.DB;
import frontend.Message;
import frontend.User;

/**
 * Servlet implementation class SendMessage
 */
@WebServlet("/SendMessageServlet")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessageServlet() {
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
		String dest = request.getParameter("target");
		User currentUser = (User)request.getSession().getAttribute("user");
		String txt = request.getParameter("txt");
		
		ServletContext context = request.getServletContext();
		DB db = (DB) context.getAttribute("db");
		
		
		db.sendMessage(new Message(currentUser.getID(), dest, txt, "" + System.currentTimeMillis()));
		
		request.getRequestDispatcher("/send_message.jsp").forward(request, response);
	}

}
