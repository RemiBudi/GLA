package com.example.jetty_jersey.ws;

import java.util.ArrayList;
import java.util.List;

public class DAO implements CommentDao, MapDao, PinDao, UserDao {

	// Comments methods
	/**
	 * @param Map
	 * @return List of comments of specific map
	 */

	public List<Comment> getComments(Map map) {

		List<Comment> commentListMap = new ArrayList<Comment>();
		return commentListMap;
	}

	/**
	 * @param Pin
	 * @return List of comments of specific pin
	 */
	public List<Comment> getComments(Pin pin) {

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

	// Map methods

	/**
	 * @param User
	 * @return the list of maps of a specific user
	 */

	public List<Map> getMaps(User user) {

		List<Map> userMapList = new ArrayList<Map>();
		return userMapList;
	}

	/**
	 * @return list of public maps
	 */

	public List<Map> getPublicMaps() {

		List<Map> publicMapList = new ArrayList<Map>();
		return publicMapList;
	}

	/**
	 * @param User (creator of the map), title of the map, description of the map
	 * @return the created map
	 */
	public Map createMap(User user, String title, String description) {

		Map newMap = new Map();
		return newMap;
	}

	/**
	 * @param Map to delete
	 * @return
	 */

	public void removeMap(Map map) {

	}

	// Pin methods
	/**
	 * @param Map
	 * @return the list of pins of a specific map
	 */

	public List<Pin> getPins(Map map) {

		List<Pin> pinMapList = new ArrayList<Pin>();
		return pinMapList;
	}

	/**
	 * @param User (creator of the pin), title of the pin, description of the pin,
	 *             location of pin, and its map
	 * @return the created pin
	 */
	public Pin createPin(User user, String title, String description, Map map, Location locaction) {

		Pin pin = new Pin();
		return pin;
	}

	/**
	 * @param Pin to delete
	 * @return
	 */

	public void removePin(Pin pin) {

	}

	// User Dao
	/**
	 * @param
	 * @return List of users of the application
	 */
	public List<User> getUser() {

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
