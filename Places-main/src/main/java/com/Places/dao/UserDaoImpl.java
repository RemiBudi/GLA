package com.Places.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.Resource;
import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.transaction.UserTransaction;

public class UserDaoImpl implements UserDao {

	private PersistenceManagerFactory pmf;

	public UserDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	/**
	 * @param
	 * @return List of users of the application
	 */
	public List<User> getUsers() {

		List<User> userList = new ArrayList<User>();
		return userList;
	}

	/**
	 * @param Username
	 * @return The User whose username corresponds to the argument
	 */
	public User getUser(String username) throws IndexOutOfBoundsException {

		// List containing the user we search
		List<User> result;
		User user;

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);

		try {
			tx.begin();

			// Query q = pm.newQuery("SELECT FROM "+User.class.getName()+" WHERE
			// userName=='\""+username+"\"'");
			Query q = pm.newQuery(User.class, "userName == '" + username + "'");

			result = (List<User>) q.execute();

			try {
				user = (User) result.iterator().next();
			} catch (NoSuchElementException e) {
				System.out.println("No user corresponding to this username");
				return null;

			}
			q.close(result);

			tx.commit();
		} finally {

			if (tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return user;
	}

	/**
	 * @param Username, Password
	 * @return The created user
	 */
	public User createUser(String username) {

		User newUser = new User(username);

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);

		tx.begin();
		try {
		pm.makePersistent(newUser);
		} catch(JDODataStoreException e) {
			System.out.println("Username already taken");
			return null;
		}
		
		tx.commit();

		if (tx.isActive()) {
			tx.rollback();
		}
		pm.close();

		System.out.println(newUser.userName);
		System.out.println(newUser.user_id);
		return newUser;
	}

	/**
	 * @param The user to be remove
	 * @return
	 */
	public void removeUser(String username) {

		
		PersistenceManager pm = pmf.getPersistenceManager();
		User user;
		
		try {
		  user = pm.getObjectById(User.class, username);
		} catch (JDOObjectNotFoundException e) {
			System.out.println("No user by this username");
			return;
		}
		pm.deletePersistent(user);
		
		pm.close();
	}

	/**
	 * @param The user whom will add the friend, the String corresponding to
	 *            friend's username
	 * @return
	 */
	public void addFriend(String user, String friend) {

		List<String> tmp = new ArrayList<String>();
	
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);

		tx.begin();
 
		
		User userAdder = pm.getObjectById(User.class, "Remsi");
		//User userFriend = pm.getObjectById(User.class, "Trizy");
		System.out.println("Add "+userAdder.userName+" and "+friend);
		
		//tmp.add(friend);
		pm.deletePersistentAll(userAdder.contacts);
		userAdder.setContacts(Arrays.asList(friend));
		System.out.print("friend"+ userAdder.getContacts().get(0));
		pm.makePersistent(userAdder);

		tx.commit();

		if (tx.isActive()) {
			tx.rollback();
		}
		pm.close();
	  


	}

}
