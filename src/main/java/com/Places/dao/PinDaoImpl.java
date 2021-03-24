package com.Places.dao;

import java.util.ArrayList;
import java.util.List;

public class PinDaoImpl implements PinDao{
	
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
		
		Pin pin = new Pin(id);
		return pin;
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

	

}
