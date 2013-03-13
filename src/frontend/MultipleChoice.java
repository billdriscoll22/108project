package frontend;

import java.util.ArrayList;

public class MultipleChoice extends Question {
	private String question;
	private ArrayList<String> answers;
	private String correctAnswer; 
	
	public MultipleChoice(String question, ArrayList<String> answers, String correctAnswer, int questionNumber){
		this.correctAnswer = correctAnswer;
		this.question = question;
		this.answers = answers;
		this.questionNumber = questionNumber;
	}
	
	public String getQuestion(){
		return question;
	}
	
	public String getCorrectAnswer(){
		return correctAnswer;
	}
	
	public ArrayList<String> getAnswers(){
		return answers;
	}
	
	public String toHTML(){
		StringBuffer html = new StringBuffer();
		html.append("<p>" + questionNumber + ". " + question + "</p>");
		html.append("<input type='radio' name='" + questionNumber + "' value='" + answers.get(0) + "'> " + answers.get(0) + "</br>");		
		html.append("<input type='radio' name='" + questionNumber + "' value='" + answers.get(1) + "'> " + answers.get(1) + "</br>");		
		html.append("<input type='radio' name='" + questionNumber + "' value='" + answers.get(2) + "'> " + answers.get(2) + "</br>");		
		html.append("<input type='radio' name='" + questionNumber + "' value='" + answers.get(3) + "'> " + answers.get(3) + "</br>");		
		return html.toString();
	}
	
	public boolean isCorrect(String answer){
		return correctAnswer.equals(answer);
	}
}
