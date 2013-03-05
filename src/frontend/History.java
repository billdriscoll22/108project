package frontend;

import java.util.ArrayList;

public class History {
	private ArrayList<Result> results;
	private final String userID;
	
	public History(String userID){
		results = new ArrayList<Result>();
		this.userID = userID;
	}
	
	public void addResult(Result result){
		results.add(result);
	}
	
	public ArrayList<Result> getResults(){
		return results;
	}
	
	public String getID(){
		return userID;
	}
	
	public String toString(){
		String result = "History for " + userID + ":\n";
		for(Result r : results){
			result += r.getPercentCorrect() + "% correct on quiz " + r.getQuiz() + " on " + r.getDateTaken() +"\n";
		}
		
		return result;
	}
	
}
