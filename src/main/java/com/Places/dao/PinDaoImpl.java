package com.Places.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

public class PinDaoImpl implements PinDao {

	private PersistenceManagerFactory pmf;

	public PinDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

	/**
	 * @param Map
	 * @return the list of pins of a specific map
	 */

	public List<Pin> getPins(Map map) {

		List<Pin> pinMapList = new ArrayList<Pin>();
		return pinMapList;
	}

	/**
	 * @param Pin id
	 * @return the pin corresponding to the specified id
	 */

	public Pin getPin(int id) {

		Pin pin = new Pin();
		return pin;
	}

	/**
	 * @param User (creator of the pin), title of the pin, description of the pin,
	 *             location of pin, and its map
	 * @return the created pin
	 */
	public Pin createPin(User user, String title, String description, Map map, Location locaction) {

		Pin pin = new Pin(new User("Test"), "TestTitle", "TestDescription", null, null);
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);

		tx.begin();

		try {
			pm.makePersistent(pin);
		} catch (JDODataStoreException e) {
			System.out.println("Username already taken");
			return null;
		}

		tx.commit();

		if (tx.isActive()) {
			tx.rollback();
		}
		pm.close();

		System.out.println(pin.title);
		System.out.println(pin.getId());
		return pin;
	}

	/**
	 * @param Pin to delete
	 * @return
	 */

	public void removePin(Long pin_id) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Pin pin;

		try {
			pin = pm.getObjectById(Pin.class, pin_id);
		} catch (JDOObjectNotFoundException e) {
			System.out.println("No user by this username");
			return;
		}
		pm.deletePersistent(pin);

		pm.close();
	}

}
