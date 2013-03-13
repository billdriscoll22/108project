package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sql.DB;
import frontend.Quiz;
import frontend.User;

/**
 * Servlet implementation class TakeQuizServlet
 */
public class TakeQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TakeQuizServlet() {
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
		
		// get quiz and store in request
		String quizID = ((String) request.getParameter("quizID"));
		Quiz quiz = db.getQuiz(quizID);
		request.setAttribute("quiz", quiz);
		
		// store user
		User user = (User)request.getSession().getAttribute("user");
		request.setAttribute("user", user);
		
		// set session attribute to track start time
		HttpSession session = request.getSession();
		session.setAttribute("startTime", new Date());
		
		// forward to correct page based on whether the quiz is single
		// or multi paged
		if(quiz.getIsOnePage())
			request.getRequestDispatcher("take_single_quiz.jsp").forward(request, response);
		else
			request.getRequestDispatcher("MultiQuizServlet").forward(request, response);
	}

}
