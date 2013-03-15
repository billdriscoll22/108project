package frontend;

import java.util.*;

import sql.DB;

public class Achievement {
	private String achievement;
	private String description;
	private String url;
	private static final String AMATEUR_AUTHOR_DESCRIPTION = "You created a quiz.  You should feel proud.";
	private static final String AMATEUR_AUTHOR = "Amateur Author";
	private static final String ACHIEVEMENT_URL = "http://media.tumblr.com/tumblr_mc42yyr7zz1qi53q4.png";
	private static final String PROLIFIC_AUTHOR = "Prolific Author";
	private static final String PROLIFIC_AUTHOR_DESCRIPTION = "You have created five quizzes. You think you are hot stuff?";
	private static final String PRODIGIOUS_AUTHOR = "Prodigious Author";
	private static final String PRODIGIOUS_AUTHOR_DESCRIPTION = "You have created ten quizzes.  You are definitely hot stuff.";
	private static final String QUIZ_MACHINE = "Quiz Machine";
	private static final String QUIZ_MACHINE_DESCRIPTION = "You have taken ten quizzes.  Do not get too full of yourself.";
	private static final String I_AM_THE_GREATEST = "I am the greatest";
	private static final String I_AM_THE_GREATEST_DESCRIPTION = "You got the highest score on a quiz.  Savor the moment.";
	/*private static final String PRACTICE_MAKES_PERFECT = "Practice Makes Perfect";
	private static final String PRACTICE_MAKES_PERFECT_DESCRIPTION = "You took a quiz in practice mode.  Almost ready for the big leagues.";*/
	
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
		return achievement + ": " + description + "<img src='" + url + "' style='height: 20px'/>";
	}
	
	public static void updateAchievements(User user, String type, Quiz quiz, DB db){
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
		/*Need to take into account them already getting it*/
		else if(type.equals("take")){
			ArrayList<Result> results = user.getResults();
			if(results.size() == 10){
				Achievement achievement = new Achievement(Achievement.QUIZ_MACHINE, Achievement.QUIZ_MACHINE_DESCRIPTION, Achievement.ACHIEVEMENT_URL);
				user.addAchievement(achievement);
			}
			ArrayList<Achievement> currentAchievements = user.getAchievements();
			boolean hasAchievement = false;
			for(Achievement a : currentAchievements){
				if(a.getName().equals(Achievement.I_AM_THE_GREATEST))
					hasAchievement = true;
			}
			if(!hasAchievement){
				ArrayList<Result> quizResults = db.getTopResults(quiz.getQuizId(), 1);
				if(quizResults.size() != 0){
					if(quizResults.get(0).getUserId().equals(user.getID())){
						Achievement achievement = new Achievement(Achievement.I_AM_THE_GREATEST, Achievement.I_AM_THE_GREATEST_DESCRIPTION, Achievement.ACHIEVEMENT_URL);
						user.addAchievement(achievement);
					}
				}
			}
		}
	}
}
