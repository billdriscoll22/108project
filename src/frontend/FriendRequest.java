package frontend;

public class FriendRequest extends Message {
	private boolean isConfirmed;
	
	public FriendRequest(String src, String dest, String body, boolean isConfirmed, String date){
		super(src, dest, body, date);
		this.isConfirmed = isConfirmed;
	}
	public boolean getStatus(){
		return isConfirmed;
	}
}
