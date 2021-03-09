package com.example.jetty_jersey.ws;

import java.util.List;

public interface UserDao {

	/**
	 * @param
	 * @return List of users of the application
	 */
	List<User> getUser();

	/**
	 * @param Username
	 * @return The User whose username corresponds to the argument
	 */
	User getUser(String username);

	/**
	 * @param Username, Password
	 * @return The created user
	 */
	User createUser(String username, String password);

	/**
	 * @param The user to be remove
	 * @return
	 */
	void removeUser(User user);

	/**
	 * @param The user to be added as friend
	 * @return
	 */
	void addUser(User user);

}
