package sql;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frontend.Achievement;
import frontend.History;
import frontend.Result;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/index.html")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB db = new DB();
		//db.addUser("matt", "lavan", false);
		//db.addUser("bill", "the drill", false);
		//db.addFriend("matt", "bill");
		//db.getFriends("matt");
		//db.removeFriend("matt", "bill");
		//db.getFriendRequests("matt");
		
		/* test methods to add result */
		//Result result = new Result("myQuiz", 100, 20, 10, "today");
		//db.addResult("Eli", result);
		//result = new Result("myQuiz", 100, 20, 5, "yesterday");
		//db.addResult("Eli", result);
		//result = new Result("myQuiz", 100, 20, 18, "tomorrow");
		//db.addResult("Eli", result);
		
		/* test method to retrieve history */
		//History h = db.getHistory("Eli");
		//System.out.println(h.toString());
		
		/* Test achievement functionality in database */
		db.addAchievement("Eli", new Achievement("Amateur Author", "Created a quiz", "www.idunno.com"));
		db.addAchievement("Eli", new Achievement("Quiz Machine", "Took ten quizes", "www.quizme.com"));
		db.addAchievement("Eli", new Achievement("Prolific Author", "Created 5 quizes", "www.idunno.com"));
		ArrayList<Achievement> list = db.getAchievements("Eli");
		System.out.println(list.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
