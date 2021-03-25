package com.Places.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.Places.dao.Map;
import com.Places.dao.MapDaoImpl;
import com.Places.dao.Pin;
import com.Places.dao.PinDaoImpl;
import com.Places.dao.User;
import com.Places.dao.UserDaoImpl;

@Path("/services")
public class WebServices {
	
	private PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("BDD");

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/maps")
	public Map getExampleMap() {
		Map instance = new Map();

		return instance;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/allmaps")
	public List<Map> getAllMap() {
		Map instance = new Map();
		Map instance2 = new Map();

		List<Map> list = new ArrayList<Map>();
		list.add(instance);
		list.add(instance2);

		return list;
	}

	//modify existing map
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/maps/{map_id}/edit")
	public void editExampleMap(@PathParam("map_id") int map_id, Map exampleMap) {
		exampleMap.setId(map_id);
		System.out.println(exampleMap.id);
	}

	//Create a user
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/users/create")
	public void createUser(String username) {
		User newUser = new UserDaoImpl(pmf).createUser(username);
	
	}
	
	//Get a user by username
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/users/search/{username}")
	public User searchUser(@PathParam("username") String username) {
		User user = new UserDaoImpl(pmf).getUser(username);
		return user;
	}
	
	
	//Remove a user
	@GET
	@Path("/users/delete/{username}")
	public void removeUser(@PathParam("username") String username){
		System.out.println(username+" To be removed");
		new UserDaoImpl(pmf).removeUser(username);
	}
	
	//Add a friend to a user
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/users/{username}/addFriend")
	public void addFriend(@PathParam("username") String username,String friendUsername) {
			//User user = new UserDaoImpl().getUser(username);
		System.out.println(username+ " et "+friendUsername);
			new UserDaoImpl(pmf).addFriend(username, friendUsername);

		}
		
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/pins/create")
	public long createPin(Pin pin) {
	   Pin newPin = new PinDaoImpl(pmf).createPin(null, pin.getTitle(), pin.getDescription(), null, null);
	   System.out.println("Pin_id:" + newPin.getId());
	   return newPin.getId();
	    } 
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pins/{pin_id}")
	public Pin getExamplePin(@PathParam("pin_id") int pin_id) {
		Pin pin = new PinDaoImpl(pmf).getPin(pin_id);
		if (pin == null)
			pin = new Pin();

		return pin;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/maps/{map_id}")
	public List<Pin> getMapPins(@PathParam("map_id") int map_id) {
		Map map = new MapDaoImpl(pmf).getMap(map_id);
		if (map == null)
			return null;

		List<Pin> listPins = new PinDaoImpl(pmf).getPins(map);
		return listPins;

	}

}
