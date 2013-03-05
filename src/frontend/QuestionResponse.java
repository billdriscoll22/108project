package frontend;

import java.util.*;

public class QuestionResponse extends Question{
	private String question;
	private ArrayList<String> answers;
	
	public String toHTML(){
		return "";
	}
	
	public boolean isCorrect(String answer){
		return false;
	}

}
