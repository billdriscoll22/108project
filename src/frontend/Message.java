package frontend;

import java.util.Date;

import sql.DB;

public class Message {
	private final String src;
	private final String dest;
	private final String body;
	private final Date time;
	
	public Message(String src, String dest, String body){
		this.src = src;
		this.dest = dest;
		this.body = body;
		this.time = new Date(); //double check this
	}
	
	public static void sendMessage(DB db, Message message){
		db.sendMessage(message);
	}
	
	
}
