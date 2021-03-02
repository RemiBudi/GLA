import java.util.ArrayList;
import java.util.List;

public class Map implements MapDao{
	
	int status;
	User owner;
	String title;
	String description;
	List<String> tags;
	List<Pin> pins;
	List<Comment> comments;
	
	
	
	/**
	 * @param User
	 * @return the list of maps of a specific user
	 */

	public List<Map> getMaps(User user){
		
		List<Map> userMapList = new ArrayList<Map>();
		return userMapList;
	}
	
	
	/**
	 * @return list of public maps
	 */

	public List<Map> getPublicMaps(){
		
		List<Map> publicMapList = new ArrayList<Map>();
		return publicMapList;
	}
	
	
	/**
	 * @param User (creator of the map), title of the map, description of the map
	 * @return the created map
	 */
	public Map createMap(User user, String title, String description) {
		
		Map newMap = new Map();
		return newMap;
	}
	
	
	/**
	 * @param Map to delete
	 * @return
	 */

	public void removeMap(Map map) {
		
	}
	
}
