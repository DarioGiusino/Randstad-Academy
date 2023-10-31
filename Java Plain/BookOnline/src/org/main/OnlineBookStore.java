package org.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.entities.Book;
import org.entities.Review;
import org.entities.User;

public class OnlineBookStore {
	private Scanner sc = new Scanner(System.in);

	// lista di user utilizzanti la libreria
	private List<User> userList = new ArrayList<>();
	// lista di book(catalogo) della libreia
	private List<Book> bookList = generateBooks();
	// lista di recensioni
	private List<Review> reviewList = new ArrayList<>();

	private Boolean isStarted = true;

	public void startBookStore() {

		while (isStarted) {
			System.out.println("** Benvenuto **\n1 - Registrati\n2 - Entra nella libreria\n3 - Esci dal sistema.");
			Integer firstChoice = sc.nextInt();

			switch (firstChoice) {
			case 1:
				addUser();
				menuUser();
				break;
			case 2:
				addBook();
				break;
			case 3:
				this.isStarted = false;
				break;
			}

		}
	}

	public void menuUser() {
		boolean loop = true;
		while (loop) {
			System.out.println(
					"** Benvenuto **\n1 - Compra libro\n2 - Scrivi recensione\n3 - home page\n4 - Esci dal sistema.");
			Integer firstChoice = sc.nextInt();

			switch (firstChoice) {
			case 1:
				showBookList();
				System.out.println("Inserisci titolo libro: ");
				String title = sc.next();
				Book book = null;
				for (Book b : this.bookList) {
					String titlelower = b.getTitle().toLowerCase();
					title.toLowerCase();
					
					if (titlelower.equals(title)) {
						book = b;
					}
				}
				buyBook(this.userList.get(userList.size() - 1), book);
				break;
			case 2:
				showBookList();
				System.out.println("Inserisci titolo libro: ");
				String title2 = sc.next();
				Book book2 = null;
				for (Book b : this.bookList) {
					if (b.getTitle().equals(title2)) {
						book = b;
					}
				}
				addReview(this.userList.get(userList.size() - 1), book2);
				break;
			case 3:
				startBookStore();
				break;
			case 4:
				System.out.println("Uscito ");
				System.exit(0);
				break;
			}
		}
	}

	public void addUser() {
		System.out.println("Inserisci nuovo nome utente: ");
		String name = sc.next();
		System.out.println("Inserisci la tua mail: ");
		String mail = sc.next();

		User newUser = new User(name, mail);

		userList.add(newUser);
		System.out.println("utente creato con successo.");
	}

	public void addBook() {
		System.out.println("Inserisci nuovo titolo libro: ");
		String title = sc.next();
		System.out.println("Inserisci autore: ");
		String autor = sc.next();
		System.out.println("Inserisci genere: ");
		String genre = sc.next();
		System.out.println("Inserisci prezzo: ");
		double price = sc.nextDouble();

		Book newBook = new Book(title, autor, genre, price);

		this.bookList.add(newBook);
		System.out.println("libro aggiunto con successo.");
	}

	public void addReview(User u, Book b) {
		System.out.println("inserisci la tua valutazione (numero compreso tra 1 e 5): ");
		Integer stars = sc.nextInt();
		System.out.println("inserisci il tuo commento testuale: ");
		String comment = sc.next();

		Review newReview = new Review(u, b, stars, comment);
		this.reviewList.add(newReview);
		System.out.println("recensione aggiunta con successo.");
	}

	public void buyBook(User u, Book b) {
		u.getBookPurchased().add(b);
		this.bookList.remove(b);
		System.out.println("Libro " + b.getTitle() + " acquistato con successo.");
	}

	public void showBookList() {
		System.out.println("**** Lista Libri ****");
		for (Book b : bookList) {
			System.out.println(b.toString());
		}

	}

	public void racomandatedBooks(User user) {

		Set<String> userGenres = new HashSet<String>();
		for (Book b : user.getBookPurchased()) {
			userGenres.add(b.getCategory().toLowerCase());
		}
		System.out.println(userGenres.toString());

		System.out.println("--- Books of Category that you like ------");
		for (Book b : this.bookList) {
			if (userGenres.contains(b.getCategory().toLowerCase()) && averageRatingBook(b) >= 4) {
				System.out.println(b.toString());
			}
		}

	}

	public void showPopularBooks() {
		Collections.sort(reviewList, (r1, r2) -> Double.compare(r1.getStars(), r2.getStars()));
		Collections.reverse(reviewList);
		System.out.println("*** Lista dei libri popolari acquistati in base alla recensione (desc) ***");
		for (Review r : reviewList) {
			if (averageRatingBook(r.getBook()) >= 4) {
				System.out.println(r.getBook().toString() + " - Valutazione: " + r.getStars());
			}
		}
	}

	public float averageRatingBook(Book book) {
		/*
		 * if (!this.reviewList.contains(book)) { System.out.println("No Reviewed");
		 * return -1; }
		 */
		float sum = 0;
		int count = 0;
		for (Review r : this.reviewList) {
			if (r.getBook().getId() == book.getId()) {
				sum += r.getStars();
				count++;
			}
		}

		return sum / count;
	}

	private List<Book> generateBooks() {
		List<Book> newList = new ArrayList<>();

		Book bo1 = new Book("Alice", "Lewis", "Fantasy", 8.5);
		Book bo2 = new Book("Pippo", "Gianfranco", "azione", 8.5);
		Book bo3 = new Book("pluto", "desc123", "azione", 9.5);
		Book bo4 = new Book("paperino", "desc789", "avventura", 2.5);

		newList.add(bo1);
		newList.add(bo2);
		newList.add(bo3);
		newList.add(bo4);

		return newList;
	}

}