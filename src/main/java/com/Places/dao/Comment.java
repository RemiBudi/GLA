package com.Places.dao;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
public class Comment {

	String author;
	int id;
	String title;
	String text;
	Pin pin;
	// Attribut date and time

	public Comment(String author,String title, String text, Pin pin) {
		this.author = author;
		//this.id = id;
		this.title = title;
		this.text = text;
		this.pin = pin;
	}
	
	public Comment(String title) {
		this.title = title;

	}
	
	public Comment(int id) {
		this.id = id;

	}

	public Comment() {

	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Pin getPin() {
		return pin;
	}

	public void setPin(Pin pin) {
		this.pin = pin;
	}

}
