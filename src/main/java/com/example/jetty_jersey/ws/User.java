package com.example.jetty_jersey.ws;

import java.util.List;

public class User {

	String userName;
	List<User> contacts;
	List<Map> myMaps;
	List<Comment> myComments;

	// Constructeur
	public User(String userName, List<User> contacts, List<Map> myMaps, List<Comment> myComments) {
		this.userName = userName;
		this.contacts = contacts;
		this.myMaps = myMaps;
		this.myComments = myComments;

	}
	
	//constructeur username
	public User(String un) {
		this.userName = un;
	}

	// Constructeur vide
	public User() {

	}

	// Getter
	public String getUserName() {
		return this.userName;
	}

	public List<User> getContacts() {
		return this.contacts;
	}

	public List<Map> getMyMaps() {
		return this.myMaps;
	}

	public List<Comment> getMyComments() {
		return this.myComments;
	}

	// Setter
	public void setUserName(String u) {
		this.userName = u;
	}

	public void setContacts(List<User> us) {
		this.contacts = us;
	}

	public void setMyMaps(List<Map> m) {
		this.myMaps = m;
	}

	public void setMyComments(List<Comment> c) {
		this.myComments = c;
	}

}
