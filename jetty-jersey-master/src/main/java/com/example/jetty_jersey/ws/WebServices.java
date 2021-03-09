package com.example.jetty_jersey.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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

}
