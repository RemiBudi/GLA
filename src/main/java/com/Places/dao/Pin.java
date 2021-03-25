package com.Places.dao;

import java.util.List;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Pin {

	long id;
	String title;
	String description;
	List<String> tags;
	Location location;

	// Constructeur
	public Pin(String title, long id, String description, List<String> tags, Location location) {
		this.title = title;
		this.id = id;
		this.description = description;
		this.tags = tags;
		this.location = location;

	}
	
	public Pin(int id) {
		this.id = id;

	}
	
	public Pin(String title) {
		this.title = title;
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
	
	

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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