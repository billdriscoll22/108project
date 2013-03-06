package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class QuizCreateServlet
 */
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
		
		if(true) {
			String quizId = request.getParameter("quizId");
			boolean isRandom = request.getParameter("order").equals("random");
			boolean isOnePage = request.getParameter("pages").equals("onePage");
			boolean isImmediate = request.getParameter("whenGraded").equals("immediate");
			
			long millisInDay = 60 * 60 * 24 * 1000;
			long currentTime = new Date().getTime();
			long dateOnly = (currentTime / millisInDay) * millisInDay;
			Date clearDate = new Date(dateOnly);
			String date = clearDate.toString();
			
			//String creatorId = ((User) request.getAttribute("user")).getID();
			String creatorId = "test";
			HttpSession session = request.getSession();
			session.setAttribute("quiz", new Quiz(quizId, creatorId, date, isRandom, isOnePage, isImmediate));
			System.out.println("done");
			RequestDispatcher dispatch = request.getRequestDispatcher("quiz_create_add_question.jsp");
			dispatch.forward(request, response);
		}
		
		
	}

}
