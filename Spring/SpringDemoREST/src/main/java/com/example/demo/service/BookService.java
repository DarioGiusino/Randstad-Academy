package com.example.demo.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;

@Service
public class BookService {

	private final Map<Long, Book> bookList = new HashMap<>();
	private Long currentId = 1L;
	
	public Book addBook(Book book) {
		book.setId(currentId++);
		bookList.put(book.getId(), book);
		return book;
	}
	
	public Collection<Book> getAllBooks(){
		return bookList.values();
	}
	
	public Book getBookById(Long id) {
		return bookList.get(id);
	}
	
	public Book updateBook(Long id, Book book) {
		if(bookList.containsKey(id)) {
			book.setId(id);
			bookList.put(id, book);
			return book;
		}
		return null;
	}
	
	public void deleteBook(Long id) {
		bookList.remove(id);
	}
}
