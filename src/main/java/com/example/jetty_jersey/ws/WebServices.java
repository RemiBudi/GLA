package com.example.jetty_jersey.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/services")
public class WebServices {

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

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/maps/{map_id}/edit")
	public void editExampleMap(@PathParam("map_id") int map_id, Map exampleMap) {
		exampleMap.setId(map_id);
		System.out.println(exampleMap.id);
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/users/{username}")
	public User getExampleUser(@PathParam("username") String username) {
		User user = new UserDaoImpl().getUser(username);
		if(user == null) user = new User(username);
		
		return user;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/pins/{pin_id}")
	public Pin getExamplePin(@PathParam("pin_id") int pin_id) {
		Pin pin = new PinDaoImpl().getPin(pin_id);
		if(pin == null) pin = new Pin(pin_id);
		
		return pin;
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/maps/{map_id}")
	public List<Pin> getMapPins(@PathParam("map_id") int map_id) {
		Map map = new MapDaoImpl().getMap(map_id);
		if(map == null) return null;
		
		List<Pin> listPins= new PinDaoImpl().getPins(map);
		return listPins;
		

	}
	

	
}
