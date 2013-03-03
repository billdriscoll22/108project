package frontend;

public class Achievement {
	private String achievement;
	private String description;
	private String url;
	
	public Achievement(String achievement, String description,  String url){
		this.achievement = achievement;
		this.description = description;
		this.url = url;											
	}
	
	public String getName(){
		return achievement;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getURL(){
		return url;
	}
	
	public String toString(){
		return achievement + ": " + description + " (" + url + ")";
	}
}
