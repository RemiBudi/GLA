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

}
