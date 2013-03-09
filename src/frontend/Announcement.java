package frontend;

public class Announcement {
	private String message;
	private String date;
	
	public Announcement(String txt, String date){
		message = txt;
		this.date = date;
	}
	
	public String getMessage(){
		return message;
	}
	
	public String getDate(){
		return date;
	}
}
