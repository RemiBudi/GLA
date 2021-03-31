package com.Places.dao;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Map {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	Long map_id;

	int status;
	
	User owner;
	String title;
	String description;
	List<String> tags;
	List<Pin> pins;
	List<Comment> comments;

	public Map(int status, long id, User owner, String title, List<String> tags, List<Pin> pins,
			List<Comment> comments) {

		this.status = status;
		this.owner = owner;
		this.title = title;
		this.tags = tags;
		this.pins = pins;
		this.comments = comments;
		this.map_id = id;
	}
	
	public Map(Long id) {
		this.map_id = id;

	}

	public Map() {

	}

	// Setter et Getter

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getId() {
		return this.map_id;
	}

	public void setId(long id) {
		this.map_id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

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

	public List<Pin> getPins() {
		return pins;
	}

	public void setPins(List<Pin> pins) {
		this.pins = pins;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	// Setter and getter

}
