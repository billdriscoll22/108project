package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sql.DB;
import frontend.Question;
import frontend.Quiz;
import frontend.Result;
import frontend.User;

/**
 * Servlet implementation class CorrectQuizServlet
 */
@WebServlet("/CorrectQuizServlet")
public class CorrectQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CorrectQuizServlet() {
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
		
		// set completion time and calculate difference
		Date endTime = new Date();
		HttpSession session = request.getSession();
		Date startTime = (Date)session.getAttribute("startTime");
		// TODO: Find the difference. Java makes this stupidly difficult
		int timeUsed = 1000;
	
		
		// get quiz
		String quizID = ((String) request.getParameter("quizID"));
		Quiz quiz = db.getQuiz(quizID);
		
		
		// correct answers
		int numQuestions = quiz.getNumQuestions();
		int numCorrect = 0;
		ArrayList<Question> questions = quiz.getQuestions();
		for(int i = 1; i <= numQuestions; i++){
			// get question
			Question q = quiz.getQuestionNum(i);
			
			// get answer to question
			String answer = request.getParameter(new Integer(i).toString());
			if(q != null && q.isCorrect(answer)) numCorrect++;
			
			if(q == null) System.out.println("Bad question");
		}
		
		// create and store result
		User user = (User)request.getSession().getAttribute("user");
		Result result = new Result(quizID, user.getID(), timeUsed, numQuestions, numCorrect, startTime.toString());
		user.addResult(result);

		// send to quiz result page
		request.getRequestDispatcher("QuizResultServlet?user=" + user.getID() +"&quiz=" + quizID).forward(request, response);

		
		
	}

}
