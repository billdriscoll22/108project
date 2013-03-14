package frontend;

import java.util.*;

public class Achievement {
	private String achievement;
	private String description;
	private String url;
	private static final String AMATEUR_AUTHOR_DESCRIPTION = "You created a quiz.  You should feel proud.";
	private static final String AMATEUR_AUTHOR = "Amateur Author";
	private static final String ACHIEVEMENT_URL = "http://media.tumblr.com/tumblr_mc42yyr7zz1qi53q4.png";
	private static final String PROLIFIC_AUTHOR = "Prolific Author";
	private static final String PROLIFIC_AUTHOR_DESCRIPTION = "You've created five quizzes. You think you're hot stuff?";
	private static final String PRODIGIOUS_AUTHOR = "Prodigious Author";
	private static final String PRODIGIOUS_AUTHOR_DESCRIPTION = "You've created ten quizzes.  You're definitely hot stuff.";
	private static final String QUIZ_MACHINE = "Quiz Machine";
	private static final String QUIZ_MACHINE_DESCRIPTION = "You've taken ten quizzes.  Don't get too full of yourself.";
	private static final String I_AM_THE_GREATEST = "I am the greatest";
	private static final String I_AM_THE_GREATEST_DESCRIPTION = "You got the highest score on a quiz.  Savor the moment.";
	private static final String PRACTICE_MAKES_PERFECT = "Practice Makes Perfect";
	private static final String PRACTICE_MAKES_PERFECT_DESCRIPTION = "You took a quiz in practice mode.  Almost ready for the big leagues.";
	
	public Achievement(String achievement, String description,  String url){
		this.achievement = achievement;
		this.description = description;
		this.url = url;											
	}
	
	public String getName(){
		return achievement;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getURL(){
		return url;
	}
	
	public String toString(){
		return achievement + ": " + description + " (" + url + ")";
	}
	
	public static void updateAchievements(User user, String type){
		if(type.equals("create")){
			ArrayList<Quiz> createdQuizzes = user.getQuizzes();
			int numCreated = createdQuizzes.size();
			/*Maybe check to see if they already have it? They can delete quizzes and remake them and keep getting achievements for it.  Whatev.*/
			if(numCreated == 1){
				Achievement achievement = new Achievement(Achievement.AMATEUR_AUTHOR, Achievement.AMATEUR_AUTHOR_DESCRIPTION, Achievement.ACHIEVEMENT_URL);
				user.addAchievement(achievement);
			}
			else if(numCreated == 5){
				Achievement achievement = new Achievement(Achievement.PROLIFIC_AUTHOR, Achievement.PROLIFIC_AUTHOR_DESCRIPTION, Achievement.ACHIEVEMENT_URL);
				user.addAchievement(achievement);
			}
			else if(numCreated == 10){
				Achievement achievement = new Achievement(Achievement.PRODIGIOUS_AUTHOR, Achievement.PRODIGIOUS_AUTHOR_DESCRIPTION, Achievement.ACHIEVEMENT_URL);
				user.addAchievement(achievement);
			}
		}
	}
}
