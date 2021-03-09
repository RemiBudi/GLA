package com.example.jetty_jersey.ws;

public class Comment {

	String author;
	String title;
	String text;
	Pin pin;
	// Attribut date and time

	public Comment(String author, String title, String text, Pin pin) {
		this.author = author;
		this.title = title;
		this.text = text;
		this.pin = pin;
	}

	public Comment() {

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
