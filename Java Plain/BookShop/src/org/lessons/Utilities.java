package org.lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utilities {

	public static <T> T userInput(Class<T> type, String s) {
		Scanner sc = new Scanner(System.in);
		System.out.println(s);

		if (type == Integer.class) {
			int userInput = sc.nextInt();
//			sc.close();
			return type.cast(userInput);

		} else if (type == Double.class) {
			double userInput2 = sc.nextDouble();
//			sc.close();
			return type.cast(userInput2);

		} else if (type == String.class) {
			String userInput3 = sc.next();
//			sc.close();
			return type.cast(userInput3);

		} else {
//			sc.close();
			throw new IllegalArgumentException("Tipo non supportato: " + type.getSimpleName());
		}
	}

	public static List<Book> generateBooks() {
		List<Book> newList = new ArrayList<>();
		Book b1 = new Book("desc1", "author1", 1.99);
		Book b2 = new Book("desc2", "author2", 2.99);
		Book b3 = new Book("desc3", "author3", 3.99);
		newList.add(b1);
		newList.add(b2);
		newList.add(b3);

		return newList;
	}

	public static void buyBook(List<Book> books, List<Book> userBooks) {
		showBooks(books);
		int bookToBuy = userInput(Integer.class, "Inserisci il numero del libro che vuoi acquistare: ");
		Book book = books.get(bookToBuy - 1);
		books.remove(bookToBuy - 1);
		userBooks.add(book);
		System.out.println("Libro acquistato con successo!!\n");
	}

	public static void showBooks(List<Book> books) {

		System.out.println("\n******** STAMPA LIBRI ***************");
		for (int i = 0; i < books.size(); i++) {
			System.out.println("--- " + (i+1) + "\n" + books.get(i));
		}
		System.out.println("*************************************\n");

	}

	public static void addBook(List<Book> books) {
		String newDesc = userInput(String.class, "Inserisci la desc del libro: ");
		String newAuth = userInput(String.class, "Inserisci l'autore del libro: ");
		Double newPrice = userInput(Double.class, "Inserisci il prezzo del libro: ");

		Book newBook = new Book(newDesc, newAuth, newPrice);
		books.add(newBook);

		System.out.println("Libro aggiunto con successo!!");
	}

	public static void removeBook(List<Book> books) {
		int length = books.size();
		if (books.size() > 0) {
			int bookToRemoveIndex = userInput(Integer.class,
					"Ci sono " + length + " libri, inserisci il numero di quello che vuoi eliminare: ");
			books.remove(bookToRemoveIndex - 1);
			System.out.println("Libro rimosso con successo!!");
		} else {
			System.err.println("Non ci sono libri disponibili.");
		}
	}

	public static void modifyBook(List<Book> books) {
		int length = books.size();
		if (books.size() > 0) {
			int bookToModifyIndex = userInput(Integer.class,
					"Ci sono " + length + " libri, inserisci il numero di quello che vuoi modificare: ");
			int propToModify = userInput(Integer.class,
					"Inserisci: \n1 - Modifica la descrizione\n2 - Modifica l'autore\n3 - Modifica il prezzo");

			Book bookToModify = books.get(bookToModifyIndex);

			switch (propToModify) {
			case 1:
				String newDesc1 = userInput(String.class, "Inserisci la nuova desc del libro: ");
				bookToModify.setDescription(newDesc1);
				break;
			case 2:
				String newAuth1 = userInput(String.class, "Inserisci la nuova desc del libro: ");
				bookToModify.setAuthor(newAuth1);
				break;
			case 3:
				Double newPrice1 = userInput(Double.class, "Inserisci la nuova desc del libro: ");
				bookToModify.setSellPrice(newPrice1);
				break;
			}

			System.out.println("Libro modificato con successo!!");

		} else {
			System.err.println("Non ci sono libri disponibili.");
		}
	}
}
