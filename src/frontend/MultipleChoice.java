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
		return "";
	}
	
	public boolean isCorrect(String answer){
		return correctAnswer.equals(answer);
	}
}
