package frontend;

import java.util.ArrayList;

public class Picture extends Question {
	private final String url;
	private final String question;
	private final ArrayList<String> answers;
	
	public Picture(String url, String question, ArrayList<String> answers, int questionNumber){
		this.url = url;
		this.question = question;
		this.answers = answers;
		this.questionNumber = questionNumber;
	}
	
	public String toHTML(){
		StringBuffer html = new StringBuffer();
		html.append("<p>" + questionNumber + ". " + question + "</p>");
		html.append("<img src='" + url + "'> ");
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
