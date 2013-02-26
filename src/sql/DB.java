package sql;

import java.util.*;

import frontend.Challenge;
import frontend.FriendRequest;
import frontend.History;
import frontend.Message;
import frontend.Result;

public class DB {
	
	public DB(){
		
	}
	
	public void addUser(String user, String hash){
		
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
	
	

}
