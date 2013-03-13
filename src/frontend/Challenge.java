package frontend;

public class Challenge extends Message {
	private String quizId;
	private double score; // the challenging user's score on the quiz (As a percentage correct)
	
	public Challenge(String src, String dest, String body, String quizId, String time, double score){
		super(src, dest, body, time);
		this.quizId = quizId;
		this.score = score;
	}
	
	public String getQuiz(){
		return quizId;
	}
	
	// get the challenging user's score
	public double getScore(){
		return score;
	}
	
	// returns an html link to the quiz
	public String toLink(){
		return "<a href='QuizViewServlet?quizID=" + quizId + "'>" + quizId + "</a>" ;
	}
	
	
}
