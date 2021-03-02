import java.util.ArrayList;
import java.util.List;

public class User implements UserDao{

	String userName;
	List<User> contacts;
	List<Map> myMaps;
	List<Comment> myComments;
	
	/**
	 * @param
	 * @return List of users of the application
	 */
	public List<User> getUser(){
		
		List<User> userList = new ArrayList<User>();
		return userList;
	}
	
	
	/**
	 * @param Username
	 * @return The User whose username corresponds to the argument
	 */
	public User getUser(String username) {
		
		User user = new User();
		return user;
	}
	
	
	/**
	 * @param Username, Password
	 * @return The created user
	 */
	public User createUser(String username, String password) {
		
		User newUser = new User();
		return newUser;
	}
	
	/**
	 * @param The user to be remove
	 * @return 
	 */
	public void removeUser(User user) {
		
	}
	
	/**
	 * @param The user to be added as friend
	 * @return
	 */
	public void addUser(User user) {
	
	}
	
	
	
}
