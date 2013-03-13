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
		
		questions = new ArrayList<Question>();
		currQuestion = 0;
		isShuffled = false;
	}
	
	// returns html code to create a link to this quiz's page
	public String toLink(){
		return "<a href='QuizViewServlet?quizID=" + quizId + "'>" + quizId + "</a>" ;
	}
	
	public String getDateCreated(){
		return dateCreated;
	}
	
	public String getQuizId(){
		return quizId;
	}
	
	public String getCreatorId(){
		return creatorId;
	}
	
	public boolean getIsRandom(){
		return isRandom;
	}
	
	public boolean getIsOnePage(){
		return isOnePage;
	}
	
	public boolean getIsImmediate(){
		return isImmediate;
	}

	public void addQuestion(Question question){
		questions.add(question);
		numQuestions++;
	}
	
	// returns the arraylist of questions
	public ArrayList<Question> getQuestions() {
		return questions;
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
	
	public int getNumQuestions() {
		return numQuestions;
	}

	// returns the question with this number
	// no error handling right now, user takes all responsibility
	// for passing valid number
	public Question getQuestionNum(int number) {
		for(Question q : questions){
			if(q.getNumber() == number) return q;
		}
		return null;
	}
	

}
