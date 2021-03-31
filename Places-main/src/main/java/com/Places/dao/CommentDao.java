package com.Places.dao;

import java.util.List;

public interface CommentDao {

	/**
	 * @param Map
	 * @return List of comments of specific map
	 */

	List<Comment> getComments(Map map);

	/**
	 * @param Pin
	 * @return List of comments of specific pin
	 */
	List<Comment> getComments(Pin pin);
	
	
	/**
	 * @param username
	 * @return List of comments from a specified user
	 */
	List<Comment> getComments(String username);

	/**
	 * @param User , title, text, map
	 * @return Comment to be posted on the map
	 */
	Comment createComment(String user, String title, String text, Map map);

	/**
	 * @param User , title, text, map
	 * @return Comment to be posted on the pin
	 */
	Comment createComment(String user, String title, String text, Pin pin);

	/**
	 * @param Comment to be remove
	 * @return
	 */
	void removeComment(Comment comment);

}
