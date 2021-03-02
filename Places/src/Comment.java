import java.util.ArrayList;
import java.util.List;

public class Comment implements CommentDao{
	
	String author;
	String title;
	String text;
	Pin pin;
	//Attribut date and time
	
	/**
	 * @param Map
	 * @return List of comments of specific map
	 */

	public List<Comment> getComments(Map map){
		
		List<Comment> commentListMap = new ArrayList<Comment>();
		return commentListMap;
	}
	
	
	/**
	 * @param Pin
	 * @return List of comments of specific pin
	 */
	public List<Comment> getComments(Pin pin){
		
		List<Comment> commentListPin = new ArrayList<Comment>();
		return commentListPin;
	}
	
	
	
	/**
	 * @param User , title, text, map
	 * @return Comment to be posted on the map
	 */
	public Comment createComment(User user, String title, String text, Map map) {
		
		Comment newCommentMap = new Comment();
		return newCommentMap;
	}
	
	
	/**
	 * @param User , title, text, map
	 * @return Comment to be posted on the pin
	 */
	public Comment createComment(User user, String title, String text, Pin pin) {
		
		Comment newCommentPin = new Comment();
		return newCommentPin;
	}
	
	
	/**
	 * @param Comment to be remove
	 * @return 
	 */
	public void removeComment(Comment comment) {
		
	}
	

}
