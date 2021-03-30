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
		
		
	
		return map.getPins();
	}

	/**
	 * @param Pin id
	 * @return the pin corresponding to the specified id
	 */

	public Pin getPin(long id) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Pin pin;

		try {
			pin = pm.getObjectById(Pin.class, id);
		} catch (JDOObjectNotFoundException e) {
			System.out.println("No pin");
			return null;
		}

		pm.close();
		return pin;

	}

	/**
	 * @param User (creator of the pin), title of the pin, description of the pin,
	 *             location of pin, and its map
	 * @return the created pin
	 */
	public Pin createPin(Long id, Long user, String title, String description, List<String> tags, float latitude, float longitude) {


		Pin pin = new Pin(id, user, title, description, tags, latitude, longitude);
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
