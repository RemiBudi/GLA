package com.Places.dao;

import java.util.List;

public interface PinDao {

	/**
	 * @param Map
	 * @return the list of pins of a specific map
	 */

	List<Pin> getPins(Map map);
	
	
	/**
	 * @param Pin id
	 * @return the pin corresponding to the specified id
	 */

	Pin getPin(long id);

	/**
	 * @param User (creator of the pin), title of the pin, description of the pin,
	 *             location of pin, and its map
	 * @return the created pin
	 */
	Pin createPin(Long id, Long user, String title, String description, List<String> tags, float latitude, float longitude );

	/**
	 * @param Pin to delete
	 * @return
	 */

	void removePin(Long pin_id);

}
