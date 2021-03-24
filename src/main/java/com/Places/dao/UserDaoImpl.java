package com.Places.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.annotation.Resource;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
import javax.transaction.UserTransaction;

public class UserDaoImpl implements UserDao {

	private PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("BDD");

	public UserDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	public UserDaoImpl() {
		// this.pmf = JDOHelper.getPersistenceManagerFactory("BDD");

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
			Query q = pm.newQuery(User.class, "userName == '\"" + username + "\"'");

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

		User newUser = new User();
		newUser.setUserName(username);

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);

		tx.begin();

		pm.makePersistent(newUser);
		tx.commit();

		if (tx.isActive()) {
			tx.rollback();
		}
		pm.close();

		System.out.println(newUser.userName);
		return newUser;
	}

	/**
	 * @param The user to be remove
	 * @return
	 */
	public void removeUser(String username) {

		List<User> result;
		PersistenceManager pm = pmf.getPersistenceManager();

		Query q = pm.newQuery(User.class, "userName == '\"" + username + "\"'");

		result = (List<User>) q.execute();

		try {
			pm.deletePersistent(result.get(0));
		} catch (IndexOutOfBoundsException e) {
			System.out.println("No user corresponding to this username");
			return;

		}
		q.close(result);
		pm.close();
	}

	/**
	 * @param The user whom will add the friend, the String corresponding to
	 *            friend's username
	 * @return
	 */
	public void addFriend(User user, String friend) {

		User friendUser = getUser(friend);
		try {
			user.contacts.add(friendUser);
		} catch (NullPointerException e) {
			System.out.println("No user corresponding to this username");
			return;
		}

		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);
		tx.begin();

		pm.makePersistent(user);
		tx.commit();

	}

}
