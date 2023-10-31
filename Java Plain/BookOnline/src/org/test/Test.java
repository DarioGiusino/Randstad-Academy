package org.test;

import org.entities.Book;
import org.entities.Review;
import org.entities.User;
import org.main.OnlineBookStore;

public class Test {

	public static void main(String[] args) {
		//testClasses();
		OnlineBookStore obs = new OnlineBookStore();
		obs.startBookStore();
		/*
		User us1 = new User("Gio","gio@ciao.it");
		Book bo1 = new Book("Alice","Lewis","Fantasy",8.5);
		Book bo2 = new Book("Pippo","Gianfranco","belooo",8.5);
		obs.addReview(us1, bo1);
		obs.addReview(us1, bo2);
		obs.showPopularBooks();
		obs.buyBook(us1, bo1);
		obs.buyBook(us1, bo2);
		obs.addBook();
		obs.racomandatedBooks(us1);
		*/
	}
	
	public static void testClasses() {
		User us1 = new User("Gio","gio@ciao.it");
		Book bo1 = new Book("Alice","Lewis","Fantasy",8.5);
		System.out.println(us1.toString());
		System.out.println(bo1.toString());
		Review re1 = new Review(us1,bo1,3,"Bello");
		System.out.println(re1.toString());
	}

}