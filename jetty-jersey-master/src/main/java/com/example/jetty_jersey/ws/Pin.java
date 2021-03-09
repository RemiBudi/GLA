package com.example.jetty_jersey.ws;

import java.util.List;

public class Pin {

	String title;
	String description;
	List<String> tags;
	Location location;

	// Constructeur
	public Pin(String title, String description, List<String> tags, Location location) {
		this.title = title;
		this.description = description;
		this.tags = tags;
		this.location = location;

	}

	// Constructeur vide
	public Pin() {

	}

	// Setter and getter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
