package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import sql.DB;
import frontend.Quiz;
import frontend.Result;
import frontend.User;

/**
 * Servlet implementation class QuizResultServlet
 */
@WebServlet("/QuizResultServlet")
public class QuizResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Get request takes userId and quizID parameters and 
		 * directs to a jsp to show the results for that user on that quiz
		 */
		
		ServletContext context = request.getServletContext();
		DB db = (DB) context.getAttribute("db");
		
		// parameters
		String quizID = request.getParameter("quiz");
		
		// set quiz attribute
		Quiz quiz = db.getQuiz(quizID);
		request.setAttribute("quiz", quiz);
		
		// set user attribute
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("user", user);
		
		// set result
		Result result = user.getResult(quizID);
		request.setAttribute("result", result);
		
		
		request.getRequestDispatcher("quiz_results.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Get request takes userId and quizID parameters and 
		 * directs to a jsp to show the results for that user on that quiz
		 */
		
		ServletContext context = request.getServletContext();
		DB db = (DB) context.getAttribute("db");
		
		// parameters
		String quizID = request.getParameter("quiz");
		
		// set quiz attribute
		Quiz quiz = db.getQuiz(quizID);
		request.setAttribute("quiz", quiz);
		
		// set user attribute
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("user", user);
		
		// set result
		Result result = user.getResult(quizID);
		request.setAttribute("result", result);
		
		
		request.getRequestDispatcher("quiz_results.jsp").forward(request, response);	
	}

}
