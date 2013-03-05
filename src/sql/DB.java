package sql;

/*hi*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.RequestDispatcher;

import frontend.Achievement;
import frontend.Challenge;
import frontend.FriendRequest;
import frontend.History;
import frontend.Message;
import frontend.Result;
import frontend.User;

public class DB {
	
	private static final String MYSQL_USERNAME = "ccs108kolyyu22";
	private static final String MYSQL_PASSWORD = "shooneon";
	private static final String MYSQL_DATABASE_SERVER = "mysql-user.stanford.edu";
	private static final String MYSQL_DATABASE_NAME = "c_cs108_kolyyu22";
	private static Connection con;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://" + MYSQL_DATABASE_SERVER + "/" + MYSQL_DATABASE_NAME;
			con = DriverManager.getConnection(url, MYSQL_USERNAME, MYSQL_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("CS108 student: Update the MySQL constants to correct values!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("CS108 student: Add the MySQL jar file to your build path!");
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
	
	public static void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addUser(String user, String hash, boolean isAdmin){
		String query = "INSERT INTO users VALUES('" + user + "', " + "'" + hash + "', " + isAdmin + ");";
		sqlUpdate(query);
	}
	
	private ResultSet getResult(String query){
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private void sqlUpdate(String query){
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	// return null if user id does not exist
	public User getUser(String id){
		// execute query
		String query = "SELECT * FROM users WHERE id = '" + id + "'";
		System.out.println(query);
		ResultSet rs = getResult(query);
		
		// check if result is empty
		try {
			if(rs.next() == false) return null;
		} catch (SQLException e) {e.printStackTrace();}
		
		// otherwise create user with query result
		String hash = null;
		boolean isAdmin = false;
		try {
			hash = rs.getString("hash");
		} catch (SQLException e) {e.printStackTrace();}
		
		try {
			isAdmin = rs.getBoolean("isAdmin");
		} catch (SQLException e) {e.printStackTrace();}
		
		return new User(id, hash, isAdmin, this);		
	}
	
	public ArrayList<String> getFriends(String userId){
		String query = "SELECT id2 FROM friends WHERE id1 = '" + userId + "';";
		ArrayList<String> list = new ArrayList<String>();
		try {
			ResultSet rs = getResult(query);
			rs.beforeFirst();
			while (rs.next()){
				list.add(rs.getString("id2"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public ArrayList<Message> getMessages(String userId){
		ArrayList<Message> returnList = new ArrayList<Message>();
		String query = "select * from notes where dest = '" + userId  + "'";
		ResultSet rs = getResult(query);
		try {
			while(rs.next()){
				returnList.add(new Message(rs.getString("src"), rs.getString("dest"), rs.getString("body"), rs.getString("time")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Message>();
		
		
	}
	
	public void addResult(String id, Result result) {		
		String query = "INSERT INTO results VALUES('" + id + "', " + "'" + result.getQuiz() + "', " 
				+ result.getTimeUsed() +  ", " 
				+ result.getNumQuestions() + ", " 
				+ result.getNumCorrect() + ", '"
				+ result.getDateTaken() + "'"
				+ ")";
		System.out.println(query);
		sqlUpdate(query);
	}
	
	public History getHistory(String userId){
		History history = new History(userId);
		
		// get all entries in the results table for this user
		String query = "SELECT * FROM results WHERE user = '" + userId + "'";
		System.out.println(query);
		ResultSet rs = getResult(query);
		
		// add each result to the history
		try{
			while(rs.next()) {
				String quiz = rs.getString("quiz");
				int time = rs.getInt("time");
				int questions = rs.getInt("questions");
				int	correct = rs.getInt("correct");
				String date = rs.getString("date");
				Result r = new Result(quiz, time, questions, correct, date);
				history.addResult(r);
			}
		} catch (SQLException e) {e.printStackTrace();}
		
		return history;
	}
	
	public void addAchievement(String userId, Achievement achievement){
		String query = "INSERT INTO achievements VALUES('" + userId + "', '" + achievement.getName() + "', '"
				+ achievement.getDescription() + "', '"
				+ achievement.getURL()
				+ "')";
		sqlUpdate(query);
		System.out.println(query);
	}
	
	public boolean getIsAdmin(String userId){
		String query = "SELECT isAdmin FROM users WHERE id = '" + userId + "';";
		ResultSet rs = getResult(query);
		boolean isAdmin = false;
		try {
			rs.absolute(1);
			isAdmin = rs.getBoolean("isAdmin");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(isAdmin);
		return isAdmin;
	}
	
	public ArrayList<Achievement> getAchievements(String userId){
		ArrayList<Achievement> list = new ArrayList<Achievement>();
		
		// get all entries in the results table for this user
		String query = "SELECT * FROM achievements WHERE user = '" + userId + "'";
		System.out.println(query);
		ResultSet rs = getResult(query);
		
		// add each achievement to the list
		try{
			while(rs.next()) {
				String achievement = rs.getString("achievement");
				String description = rs.getString("description");
				String url = rs.getString("url");
				list.add(new Achievement(achievement, description, url));				
			}
		} catch (SQLException e) {e.printStackTrace();
		}
		
		return list;
	}
	
	
	public ArrayList<Challenge> getChallenges(String userId){
		String query = "SELECT * FROM challenges WHERE destination='" + userId + "'";
		ArrayList<Challenge> challenges = new ArrayList<Challenge>();
		try {
			ResultSet rs = getResult(query);
			rs.beforeFirst();
			while(rs.next()) {
				String src = rs.getString("src");
				String body = rs.getString("body");
				String url = rs.getString("url");
				String time = rs.getString("time");
				Challenge c = new Challenge(src, userId, body, url, time);
				challenges.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return challenges;
	}
	
	public void addFriend(String user1, String user2){
		String query = "INSERT INTO friends VALUES('" + user1 + "', '" + user2 + "');";
		sqlUpdate(query);
		query = "UPDATE requests SET isConfirmed = true WHERE source = '" + user1 + "' AND dest = '" + user2 + "';";
		sqlUpdate(query);
	}

	public void removeFriend(String id, String id2) {
		String query = "DELETE FROM friends WHERE id1 = '" + id + "' AND id2 = '" + id2 + "';";
		sqlUpdate(query);
		query = "DELETE FROM friends WHERE id1 = '" + id2 + "' AND id2 = '" + id + "';";
		sqlUpdate(query);
		query = "DELETE FROM requests WHERE source = '" + id + "' AND dest = '" + id2 + "';";
		sqlUpdate(query);
		query = "DELETE FROM requests WHERE source = '" + id2 + "' AND dest = '" + id + "';";
		sqlUpdate(query);
	}

	public ArrayList<FriendRequest> getFriendRequests(String id) {
		String query = "SELECT * FROM requests WHERE dest = '" + id + "';";
		ArrayList<FriendRequest> list = new ArrayList<FriendRequest>();
		try {
			ResultSet rs = getResult(query);
			rs.beforeFirst();
			while (rs.next()){
				String source = rs.getString("source");
				boolean isConfirmed = rs.getBoolean("isConfirmed");
				String time = rs.getString("time");
				String body = source + " has added you as a friend!";
				FriendRequest fr = new FriendRequest(source, id, body, isConfirmed, time);
				list.add(fr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void sendFriendRequest(String id1, String id2){
		Date date = new Date();
		String dateAsStr = date.toString();
		String query = "INSERT INTO requests VALUES('" + id1 + "', '" + id2 + "', false, '" + dateAsStr + "');";
		sqlUpdate(query);
	}

	

	public void setAdminStatus(String id, boolean status) {
		String query = "UPDATE users SET isAdmin = '" + status + "' WHERE id = '" + id + "'";
		System.out.println(query);
		sqlUpdate(query);		
	}

	public void sendMessage(Message message) {
		String src = message.getSrc();
		String dest = message.getDest();
		String body = message.getBody();
		String time = message.getTime();
		String query = "INSERT INTO notes VALUES('" + src + "', '" + dest + "', '" + body + "', '" + time + "');";
		sqlUpdate(query);
	}

}
