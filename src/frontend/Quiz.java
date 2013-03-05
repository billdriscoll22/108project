package frontend;

import java.util.ArrayList;

public class Quiz {
	private String quizId;
	private String creatorId;
	private String dateCreated;
	private int numQuestions;
	private ArrayList<Question> questions;
	private boolean isRandom;
	private boolean isOnePage;
	private boolean isImmediate;
	
	public Quiz(String quizId, String creatorId, boolean isRandom, boolean isOnePage, boolean isImmediate){
		this.quizId = quizId;
		this.creatorId = creatorId;
		this.isRandom = isRandom;
		this.isOnePage = isOnePage;
		this.isImmediate = isImmediate;
	}
	
	public void addQuestion(Question question){
		
	}
	
	public Question nextQuestion(){
		return new Question();
	}
	
	
	

}
