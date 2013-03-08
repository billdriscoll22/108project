package frontend;

import java.util.Date;

import sql.DB;

public class Message {
	private final String src;
	private final String dest;
	private final String body;
	private final String time;
	
	public Message(String src, String dest, String body, String time){
		this.src = src;
		this.dest = dest;
		this.body = body;
		this.time = time; //double check this
	}
	
	public static void sendMessage(DB db, Message message){
		db.sendMessage(message);
	}
	
	public String getSrc(){
		return src;
	}
	public String getDest(){
		return dest;
	}
	public String getBody(){
		return body;
	}
	public String getTime(){
		return time;
	}
	
	public String toHTML(){
		String starter = "";
		starter += ("From: " + this.getSrc() + " at: " + this.getTime() + "<br/>");
		starter += (this.getBody() + "<br/>");
		return starter;
	}
	
	
}
