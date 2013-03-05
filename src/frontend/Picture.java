package frontend;

import java.util.ArrayList;

public class Picture extends Question {
	private final String URL;
	private final String question;
	private final ArrayList<String> answers;
	
	public Picture(String url, String question, ArrayList<String> answers, int questionNumber){
		this.URL = url;
		this.question = question;
		this.answers = answers;
		this.questionNumber = questionNumber;
	}
	
	public String toHTML(){
		return "";
	}
	
	public boolean isCorrect(String answer){
		// check user's answer against all possible answers
		// ignore case
		for(String s : answers){
			if(answer.equalsIgnoreCase(s)) return true;
		}
		
		return false;
	}
}
