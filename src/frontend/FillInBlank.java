package frontend;

import java.util.ArrayList;

public class FillInBlank extends Question {
	private ArrayList<String> questions;
	private ArrayList<String> answers;
	private int number;
	
	public String toHTML(){
		return "";
	}
	
	public boolean isCorrect(String answer){
		return false;
	}
}
