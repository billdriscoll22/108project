package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import frontend.Quiz;
import frontend.Result;
import frontend.User;

import sql.DB;

/**
 * Servlet implementation class QuizViewServlet
 */
@WebServlet("/QuizViewServlet")
public class QuizViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = request.getServletContext();
		DB db = (DB) context.getAttribute("db");

		String quizID = ((String) request.getParameter("quizID"));
		
		// get quiz and store in request
		Quiz quiz = db.getQuiz(quizID);
		request.setAttribute("quiz", quiz);
		HttpSession session = request.getSession();
		session.setAttribute("quizID", quizID);
		
		//average
		Double average = db.getQuizAverage(quizID);
		request.setAttribute("averageRight", average);
		Double averageTime = db.getTimeAverage(quizID);
		request.setAttribute("averageTime", averageTime);
		
		// get top results
		int NUM_TOP_SCORES_TO_SHOW = 5;
		ArrayList<Result> topScores = db.getTopResults(quiz.getQuizId(), NUM_TOP_SCORES_TO_SHOW);
		request.setAttribute("topScores", topScores);
		
		//get top results within last 24 hours
		ArrayList<Result> top24 = db.getLast24HourResults(quiz.getQuizId(), NUM_TOP_SCORES_TO_SHOW);
		request.setAttribute("top24", top24);
		
		//Get most recent results
		ArrayList<Result> mostRecent = db.getRecentQuizResults(quiz.getQuizId(), 5);
		request.setAttribute("mostRecent", mostRecent);
		
		// get user's results for this quiz
		User user = (User) request.getSession().getAttribute("user");
		ArrayList<Result> userResults = db.getQuizResults(quizID, user.getID());
		request.setAttribute("userResults", userResults);
		
		
		request.getRequestDispatcher("/view_quiz.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
