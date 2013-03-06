package frontend;

import java.util.ArrayList;

public class MultipleChoice extends Question {
	private String question;
	private ArrayList<String> answers;
	private String correctAnswer; // ie "A" "B "C" or "D"
	
	public MultipleChoice(String question, ArrayList<String> answers, String correctAnswer, int questionNumber){
		this.correctAnswer = correctAnswer;
		this.question = question;
		this.answers = answers;
		this.questionNumber = questionNumber;
	}
	
	public String toHTML(){
		StringBuffer html = new StringBuffer();
		html.append("<p>" + questionNumber + ". " + question + "</p>");
		html.append("<input type='radio' name='" + questionNumber + "' value='A'> " + answers.get(0) + "><br>");		
		html.append("<input type='radio' name='" + questionNumber + "' value='B'> " + answers.get(1) + "><br>");		
		html.append("<input type='radio' name='" + questionNumber + "' value='C'> " + answers.get(2) + "><br>");		
		html.append("<input type='radio' name='" + questionNumber + "' value='D'> " + answers.get(3) + "><br>");		
		return html.toString();
	}
	
	public boolean isCorrect(String answer){
		return correctAnswer.equals(answer);
	}
}
