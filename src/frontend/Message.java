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
	
	
}
