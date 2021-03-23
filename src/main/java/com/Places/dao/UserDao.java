package com.Places.dao;

import java.util.List;

public interface UserDao {

	/**
	 * @param
	 * @return List of users of the application
	 */
	List<User> getUsers();

	/**
	 * @param Username
	 * @return The User whose username corresponds to the argument
	 */
	User getUser(String username);

	/**
	 * @param Username, Password
	 * @return The created user
	 */
	User createUser(String username);

	/**
	 * @param The user to be remove
	 * @return
	 */
	void removeUser(String username);

	/**
	 * @param The user to be added as friend
	 * @return
	 */
	void addFriend(User user, String friend);

}
