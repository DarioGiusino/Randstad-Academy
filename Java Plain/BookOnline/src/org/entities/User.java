package org.entities;

import java.util.ArrayList;

public class User {
	static int counter = 0;
	int id;
	String name;
	String email;
	ArrayList<Book> bookPurchased;
	
	public User(String name, String email) {
		this.id = ++counter;
		this.name = name;
		this.email = email;
		this.bookPurchased = new ArrayList<Book>();
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}


	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Book> getBookPurchased() {
		return bookPurchased;
	}

	public void setBookPurchased(ArrayList<Book> bookPurchased) {
		this.bookPurchased = bookPurchased;
	}
	
	
}
