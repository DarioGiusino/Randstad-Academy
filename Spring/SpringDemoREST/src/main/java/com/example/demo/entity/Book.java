package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	private String author;
	private Integer publishyear;

	public Book() {
	};

	public Book(Long id, String title, String author, Integer publishyear) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publishyear = publishyear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPublishyear() {
		return publishyear;
	}

	public void setPublishyear(Integer publishyear) {
		this.publishyear = publishyear;
	}

}
