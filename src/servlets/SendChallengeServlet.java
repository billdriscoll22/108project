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
import frontend.Challenge;
import frontend.Message;
import frontend.User;

/**
 * Servlet implementation class SendChallengeServelet
 */
@WebServlet("/SendChallengeServlet")
public class SendChallengeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendChallengeServlet() {
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
		String dest = request.getParameter("friend");
		User currentUser = (User)request.getSession().getAttribute("user");
		String txt = request.getParameter("txt");
		String quiz = request.getParameter("quiz");
		
		ServletContext context = request.getServletContext();
		DB db = (DB) context.getAttribute("db");
		
		db.sendMessage(new Challenge(currentUser.getID(), dest, txt, quiz, new Date().toString(), currentUser.getBestScore(quiz)));
		request.getRequestDispatcher("/send_challenge.jsp").forward(request, response);
			
		
		
	}

}
