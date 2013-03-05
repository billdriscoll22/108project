package frontend;

import java.util.ArrayList;
import java.util.Collections;

public class Quiz {
	private String quizId;
	private String creatorId;
	private String dateCreated;
	private int numQuestions;
	private ArrayList<Question> questions;
	private boolean isRandom;
	private boolean isOnePage;
	private boolean isImmediate;
	private int currQuestion; // keep track of the next question to give out
	private boolean isShuffled; // keep track of whether or not the questions have been shuffled yet
	
	public Quiz(String quizId, String creatorId, boolean isRandom, boolean isOnePage, boolean isImmediate){
		this.quizId = quizId;
		this.creatorId = creatorId;
		this.isRandom = isRandom;
		this.isOnePage = isOnePage;
		this.isImmediate = isImmediate;
		currQuestion = 0;
		isShuffled = false;
	}
	
	public void addQuestion(Question question){
		questions.add(question);
		numQuestions++;
	}
	
	// returns the next question in the quiz, or null if all questions have been
	// given out
	public Question nextQuestion(){
		// if random mode is on, shuffle the questions if they haven't yet been shuffled
		if(isRandom && !isShuffled){
			Collections.shuffle(questions);
			isShuffled = true;
		}
		
		// check if all the questions have been given already
		if(currQuestion >= numQuestions) return null;
		else return questions.get(currQuestion++); // return question and increment tracking variable
	}
	
	
	

}
