import java.util.List;

public interface PinDao {
	
	/**
	 * @param Map
	 * @return the list of pins of a specific map
	 */

	List<Pin> getPins(Map map);

	
	/**
	 * @param User (creator of the pin), title of the pin, description of the pin, location of pin, and its map
	 * @return the created pin
	 */
	Pin createPin(User user, String title, String description, Map map, Location locaction);
	
	
	
	/**
	 * @param Pin to delete
	 * @return
	 */

	void removePin(Pin pin);

	
	

}
