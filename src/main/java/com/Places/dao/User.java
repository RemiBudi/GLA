package com.Places.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@PersistenceCapable
public class User {

	
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	long user_id;
	
	@PrimaryKey
	String userName;

	@ElementCollection
	List<String> contacts = new ArrayList<String>();
	
	List<Map> myMaps;
	List<Comment> myComments;

	// Constructeur
	public User(String userName, List<String> contacts, List<Map> myMaps, List<Comment> myComments) {
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
	
	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	// Getter
	public String getUserName() {
		return this.userName;
	}

	public List<String> getContacts() {
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

	public void setContacts(List<String> us) {
		this.contacts = us;
	}

	public void setMyMaps(List<Map> m) {
		this.myMaps = m;
	}

	public void setMyComments(List<Comment> c) {
		this.myComments = c;
	}

}
