package frontend;

import java.util.*;

public class QuestionResponse extends Question{
	private final String question;
	private final ArrayList<String> answers;
	
	public QuestionResponse(String question, ArrayList<String> answers, int questionNumber){
		this.question = question;
		this.answers = answers;
		this.questionNumber = questionNumber;
	}
	
	public ArrayList<String> getAnswers(){
		return answers;
	}
	
	public String getQuestion(){
		return question;
	}
	
	public String toHTML(){
		StringBuffer html = new StringBuffer();
		html.append("<p>" + questionNumber + ". " + question + "</p>");
		html.append("Answer: <input type='text' name='" + questionNumber + "'><br>");		
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
