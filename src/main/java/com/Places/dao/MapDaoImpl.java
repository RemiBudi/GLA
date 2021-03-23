package com.Places.dao;

import java.util.ArrayList;
import java.util.List;

public class MapDaoImpl implements MapDao{
	
	/**
	 * @param User
	 * @return the list of maps of a specific user
	 */

	public List<Map> getMaps(User user) {

		List<Map> userMapList = new ArrayList<Map>();
		return userMapList;
	}
	
	/**
	 * @param map_id
	 * @return the map corresponding to the id
	 */

	public Map getMap(int id) {
		
		Map map = new Map(id);
		return map;
	}

	/**
	 * @return list of public maps
	 */

	public List<Map> getPublicMaps() {

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
