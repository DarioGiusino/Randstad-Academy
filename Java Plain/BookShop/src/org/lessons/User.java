package org.lessons;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String role;
	private List<Book> books = new ArrayList<>();

	public User() {
		setRole("guest");
		setBooks(books);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
