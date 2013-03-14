package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sql.DB;
import frontend.Achievement;
import frontend.FillInBlank;
import frontend.MultipleChoice;
import frontend.Picture;
import frontend.QuestionResponse;
import frontend.Quiz;
import frontend.User;

/**
 * Servlet implementation class QuizCreateServlet
 */
@WebServlet("/QuizCreateServlet")
public class QuizCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizCreateServlet() {
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
		
		if(request.getParameter("init").equals("Create Quiz")) {
			
			// Creates quiz object with basic specifications, directs user to quiz_create_add_question.jsp
			
			String quizId = request.getParameter("quizId");
			boolean isRandom = request.getParameter("order").equals("random");
			boolean isOnePage = request.getParameter("pages").equals("onePage");
			boolean isImmediate = request.getParameter("whenGraded").equals("immediate");
			String image = request.getParameter("imageURL");
			String imageURL = (image.equals("Image URL")) ? "http://www.apassionforafrica.com/wp-content/uploads/2013/02/Quiz.jpg" : image;
			String description = request.getParameter("description");
			
			long millisInDay = 60 * 60 * 24 * 1000;
			long currentTime = new Date().getTime();
			long dateOnly = (currentTime / millisInDay) * millisInDay;
			Date clearDate = new Date(dateOnly);
			String date = clearDate.toString();	
			
			HttpSession session = request.getSession();
			
			if(isOnePage && isImmediate) {
				session.setAttribute("multi", true);
				RequestDispatcher dispatch = request.getRequestDispatcher("quiz_create_init.jsp");
				dispatch.forward(request, response);
			} else {
				String creatorId = ((User) session.getAttribute("user")).getID();
				session.setAttribute("quiz", new Quiz(quizId, creatorId, date, isRandom, isOnePage, isImmediate, imageURL, description));
				System.out.println("done");
				RequestDispatcher dispatch = request.getRequestDispatcher("quiz_create_add_question.jsp");
				dispatch.forward(request, response);
			}
		} 
		
		else if(request.getParameter("init").equals("Create Question")) {
			
			// user picks which type of question to make, direct to type-specific .jsp (for the moment,
			// this can be changed)
			
			String type = request.getParameter("questionType");
			if(type.equals("questionResponse")) {
				RequestDispatcher dispatch = request.getRequestDispatcher("quiz_create_QR.jsp");
				dispatch.forward(request, response);
			} 
			
			else if(type.equals("multipleChoice")) {
				RequestDispatcher dispatch = request.getRequestDispatcher("quiz_create_MC.jsp");
				dispatch.forward(request, response);
			} 
			
			else if(type.equals("pictureResponse")) {
				RequestDispatcher dispatch = request.getRequestDispatcher("quiz_create_PR.jsp");
				dispatch.forward(request, response);
			} 
			
			else if(type.equals("fillInBlank")) {
				RequestDispatcher dispatch = request.getRequestDispatcher("quiz_create_FB.jsp");
				dispatch.forward(request, response);
			}
		} 
		
		else if(request.getParameter("init").equals("No More Questions!")) {
			// this will add quiz to DB and redirect to home page -- right now just sends to login page
			// to avoid problems with user being set in session
			HttpSession session = request.getSession();
			Quiz quiz = (Quiz) session.getAttribute("quiz");
			db.addQuiz(quiz);
			User user = ((User) session.getAttribute("user"));
			Achievement.updateAchievements(user, "create", null, null);
			RequestDispatcher dispatch = request.getRequestDispatcher("HomeServlet");
			dispatch.forward(request, response);
		} 
		
		else if(request.getParameter("init").equals("Add Question-Response")) {
			
			// adds question-response to quiz
			
			String question = request.getParameter("questionText");
			String answer = request.getParameter("questionAnswer");
			ArrayList<String> answers = parseAnswers(answer);

			for(String a : answers)
				System.out.println(a);
			
			HttpSession session = request.getSession();
			Quiz q = (Quiz) session.getAttribute("quiz");
			
			QuestionResponse qr = new QuestionResponse(question, answers, q.getNumQuestions()+1);
			q.addQuestion(qr);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("quiz_create_add_question.jsp");
			dispatch.forward(request, response);
		} 
		
		else if(request.getParameter("init").equals("Add Multiple Choice")) {
			String question = request.getParameter("questionText");
			ArrayList<String> answers = new ArrayList<String>();
			for(int i = 0; i < 4; i++) {
				answers.add(request.getParameter("mcAnswer" + i));
			}
			String correct = request.getParameter(request.getParameter("correctAnswer"));
			
			HttpSession session = request.getSession();
			Quiz q = (Quiz) session.getAttribute("quiz");
			
			MultipleChoice mc = new MultipleChoice(question, answers, correct, q.getNumQuestions()+1);
			q.addQuestion(mc);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("quiz_create_add_question.jsp");
			dispatch.forward(request, response);
		} 
		
		else if(request.getParameter("init").equals("Add Picture Response")) {
			String image = request.getParameter("uploadField");
			String question = request.getParameter("questionText");
			ArrayList<String> answers = parseAnswers(request.getParameter("questionAnswer"));
			
			HttpSession session = request.getSession();
			Quiz q = (Quiz) session.getAttribute("quiz");
			
			Picture pr = new Picture(image, question, answers, q.getNumQuestions()+1);
			q.addQuestion(pr);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("quiz_create_add_question.jsp");
			dispatch.forward(request, response);
		}
		
		else if(request.getParameter("init").equals("Add FIB Response")) {
			ArrayList<String> questions = new ArrayList<String>();
			questions.add(request.getParameter("beforeText"));
			questions.add(request.getParameter("afterText"));
			
			ArrayList<String> answers = parseAnswers(request.getParameter("questionAnswer"));
			
			HttpSession session = request.getSession();
			Quiz q = (Quiz) session.getAttribute("quiz");
			
			FillInBlank fib = new FillInBlank(questions, answers, q.getNumQuestions()+1);
			q.addQuestion(fib);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("quiz_create_add_question.jsp");
			dispatch.forward(request, response);
		}
	}
	
	private ArrayList<String> parseAnswers(String list) {
		ArrayList<String> answers = new ArrayList<String>();
		String[] temp = list.split(":");
		for(String a : temp) {
			if (a.charAt(0) == ' ' && a.length() > 0) a = a.substring(1);
			if (a.length() > 1 && a.charAt(a.length()-1) == ' ' ) a = a.substring(0, a.length()-1);
			answers.add(a);
		}
		return answers;
	}

}
