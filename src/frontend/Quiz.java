package frontend;

import java.util.ArrayList;

import java.util.Collections;

public class Quiz {
	private final String quizId;
	private final String creatorId;
	private final String dateCreated;
	private int numQuestions;
	private ArrayList<Question> questions;
	private final boolean isRandom;
	private final boolean isOnePage;
	private final boolean isImmediate;
	private int currQuestion; // keep track of the next question to give out
	private boolean isShuffled; // keep track of whether or not the questions have been shuffled yet
	
	public Quiz(String quizId, String creatorId, String dateCreated, boolean isRandom, boolean isOnePage, boolean isImmediate){
		this.quizId = quizId;
		this.creatorId = creatorId;
		this.isRandom = isRandom;
		this.isOnePage = isOnePage;
		this.isImmediate = isImmediate;
		this.dateCreated = dateCreated;
		
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
