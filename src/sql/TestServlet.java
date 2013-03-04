package sql;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frontend.FriendRequest;
import frontend.User;

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
		// TODO Auto-generated method stub
		DB db = new DB();
		//db.addUser("matt", "lavan", false);
		User ml = new User("matt", "lavan", false, db);
		db.addUser("bill", "the drill", false);
		db.sendFriendRequest("matt", "bill");
		/*ArrayList<FriendRequest> list = db.getFriendRequests("bill");
		System.out.println("1");
		for (FriendRequest fr : list){
			System.out.println(fr.getSrc());
			System.out.println(fr.getDest());
			System.out.println(fr.getBody());
			System.out.println(fr.getTime());
			System.out.println(fr.getStatus());
		}*/
		db.addFriend("matt", "bill");
		db.removeFriend("matt", "bill");
		db.setAdminStatus("matt", true);
		db.getIsAdmin("matt");
		db.getIsAdmin("bill");
		//db.getFriendRequests("matt");
		/*Date date = new Date();
		String str = date.toString();
		System.out.println(str);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
