package com.Places.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

public class MapDaoImpl implements MapDao {

	private PersistenceManagerFactory pmf;

	public MapDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}

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

	public Map getMap(long id) {

		PersistenceManager pm = pmf.getPersistenceManager();
		Map map;

		try {
			map = pm.getObjectById(Map.class, id);
		} catch (JDOObjectNotFoundException e) {
			System.out.println("No map by this id");
			return null;
		}

		pm.close();
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
