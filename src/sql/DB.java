package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.servlet.RequestDispatcher;

import frontend.Challenge;
import frontend.FriendRequest;
import frontend.History;
import frontend.Message;
import frontend.Result;

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
	
	/*
	 * CS108 student: Do not add/remove any methods to this file since this file will be replaced
	 * when we test your code!
	 */
	
	public void addUser(String user, String hash, boolean isAdmin){
		String query = "Insert into users values('" + user + "', " + "'" + hash + "'," + isAdmin + ")";
		System.out.println(query);
		
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
	
	public ArrayList<String> getFriends(String userId){
		return new ArrayList<String>();
	}
	
	public ArrayList<Message> getMessages(String userId){
		return new ArrayList<Message>();
	}
	
	public History getHistory(String userId){
		return null;
	}
	
	public ArrayList<String> getAchievements(String userId){
		return null;
	}
	
	public boolean getIsAdmin(String userId){
		return false;
	}
	
	public void addAchievement(String userId, String achievement){
		
	}
	
	public ArrayList<Challenge> getChallenges(String userId){
		return null;
	}
	
	public void addFriend(String user1, String user2){
		
	}

	public void removeFriend(String id, String id2) {
	}

	public ArrayList<FriendRequest> getFriendRequests(String id) {
		return null;
	}

	public void addResult(String id, Result result) {
		// TODO Auto-generated method stub
		
	}

	public void setAdminStatus(String id, boolean status) {
		// TODO Auto-generated method stub
		
	}

	public void sendMessage(Message message) {
		// TODO Auto-generated method stub
		
	}
	
	public void main(){
		addUser("hi", "sup", false);
	}
	
	

}
