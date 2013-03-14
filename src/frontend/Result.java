package frontend;

public class Result {
	private final String quizID; // quiz that was taken
	private final int elapsedTime; // time used in seconds
	private final int numQuestions; // the total amount of questions asked
	private final int numCorrect; // the number of questions answered correctly
	private final String date; // date when the quiz was taken
	private final String userId;
	
	public Result(String quiz, String userId, int timeUsed, int numQuestions, int numCorrect, String date){
		quizID = quiz;
		elapsedTime = timeUsed;
		this.numQuestions = numQuestions;
		this.numCorrect = numCorrect;
		this.date = date;	
		this.userId = userId;
	}
	
	// returns an html link to view the results for this user
		public String getResultLink(){
			return "<a href='QuizResultServlet?quiz=" + quizID + "'>" + quizID + "</a>" ;
		}
	
	public String getQuiz(){
		return quizID;
	}
	
	public int getTimeUsed(){
		return elapsedTime;
	}
	
	public int getNumCorrect(){
		return numCorrect;
	}
	
	public int getNumQuestions(){
		return numQuestions;
	}
	
	public String getDateTaken(){
		return date;
	}
	
	public String getUserId(){
		return this.userId;
	}
	
	public double getPercentCorrect(){
		return (100.0 * ((double)numCorrect)/numQuestions);
	}	
}