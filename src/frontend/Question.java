package frontend;

public abstract class Question {
	protected int questionNumber;
	
	
	public int getNumber(){
		return questionNumber;
	}
	
	public abstract String toHTML();
	public abstract boolean isCorrect(String answer);
	
	

}
