package frontend;

import java.util.ArrayList;

public abstract class Question {
	protected int questionNumber;
	
	
	public int getNumber(){
		return questionNumber;
	}
	
	public abstract String getQuestion();
	public abstract String toHTML();
	public abstract boolean isCorrect(String answer);
	public abstract ArrayList<String> getAnswers();
	

}
