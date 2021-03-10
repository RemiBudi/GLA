package com.example.jetty_jersey.ws;

import java.util.List;

public class Map {

	int status;
	int id;
	User owner;
	String title;
	String description;
	List<String> tags;
	List<Pin> pins;
	List<Comment> comments;

	public Map(int status, int id, User owner, String title, List<String> tags, List<Pin> pins,
			List<Comment> comments) {

		this.status = status;
		this.owner = owner;
		this.title = title;
		this.tags = tags;
		this.pins = pins;
		this.comments = comments;
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
