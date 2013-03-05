package frontend;

import java.util.ArrayList;

public class FillInBlank extends Question {
	private ArrayList<String> questions;
	private ArrayList<String> answers;
	
	// questions array will contain two strings, representing the phrases
	// before and after the "blank"
	public FillInBlank(ArrayList<String> questions, ArrayList<String> answers, int questionNumber){
		this.questions = questions;
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
