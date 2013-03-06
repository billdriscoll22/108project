package frontend;

import java.util.ArrayList;

public class FillInBlank extends Question {
	private ArrayList<String> questions;
	private ArrayList<String> answers;
	private int number;
	
	
	// questions array will contain two strings, representing the phrases
	// before and after the "blank"
	public FillInBlank(ArrayList<String> questions, ArrayList<String> answers, int questionNumber){
		this.questions = questions;
		this.answers = answers;
		this.questionNumber = questionNumber;
	}
	
	public String toHTML(){
		StringBuffer html = new StringBuffer();
		html.append("<p>" + questionNumber + ". " + questions.get(0) + " ________ " + questions.get(1) + "</p>");
		html.append("Fill in the Blank: <input type='text' name='" + questionNumber + "'><br>");		
		return html.toString();
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
