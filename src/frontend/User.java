package frontend;

import java.util.*;

import sql.DB;

public class User {
	private final String id;
	private final DB db;
	
	public User(String user, String password, boolean isAdmin, DB db){
		this.db = db;
		this.id = user;
		String hash = hash(password);
		db.addUser(user, hash, isAdmin);
	}
	
	private String hash(String raw){
		return raw + "a";
	}
	
	public ArrayList<String> getFriends(){
		return db.getFriends(this.id);
	}
	
	public ArrayList<Message> getMessages(){
		return db.getMessages(this.id);
	}
	
	public History getHistory(){
		return db.getHistory(this.id);
	}
	
	public ArrayList<String> getAchievements(){
		return db.getAchievements(this.id);
	}
	
	public boolean isAdmin(){
		return db.getIsAdmin(this.id);
	}
	
	public void addAchievement(String achievement){
		db.addAchievement(this.id, achievement);
	}
	
	public ArrayList<Challenge> getChallenges(){
		return db.getChallenges(this.id);
	}
	
	public void addFriend(String id){
		db.addFriend(this.id, id);
	}
	
	public void removeFriend(String id){
		db.removeFriend(this.id, id);
	}
	
	public ArrayList<FriendRequest> getFriendRequests(){
		return db.getFriendRequests(this.id);
	}
	
	public void addResult(Result result){
		db.addResult(this.id, result);
	}
	
	public void setAdminStatus(boolean status){
		db.setAdminStatus(this.id, status);
	}
}




