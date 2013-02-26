package frontend;

public class FriendRequest extends Message {
	private boolean isConfirmed;
	
	public FriendRequest(String src, String dest, String body, boolean isConfirmed){
		super(src, dest, body);
		this.isConfirmed = isConfirmed;
	}
}
