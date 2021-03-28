package com.Places.dao;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;



@PersistenceCapable
public class Pin {

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private Long id;
	
	Long user;
	String title;
	String description;
	List<String> tags;
	float latitude;
	float longitude;

	// Constructeur
	public Pin(long user, String title, String description, List<String> tags) {
		this.user = user;
		this.title = title;
		this.description = description;
		this.tags = tags;

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

	public void setId(Long id) {
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




	public Long getUser() {
		return user;
	}


	public void setUser(Long user) {
		this.user = user;
	}


	public float getLatitude() {
		return latitude;
	}


	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}


	public float getLongitude() {
		return longitude;
	}


	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}


}
