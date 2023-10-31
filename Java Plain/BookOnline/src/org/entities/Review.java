package org.entities;

public class Review {
	
	User user;
	Book book;
	int stars;
	String comment;
	
	public Review(User user, Book book, int stars, String comment) {
		this.user = user;
		this.book = book;
		this.stars = stars;
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Review [\nuser=" + user.toString() + "" 
				+ "\n book=" + book.toString() + "" 
				+ "\n stars=" + stars + ", comment=" + comment + "]";
	}
	
	
	// getters and setters
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
