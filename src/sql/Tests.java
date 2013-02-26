package sql;

public class Tests {

	public Tests(){
		
	}
	
	public static void main(){
		DB db = new DB();
		db.addUser("hi", "sup", false);
	}
}
