package org.lessons;

import java.util.List;
import java.util.Scanner;

public class Shop {
	// utilities
	static final String PASSWORD = "password";
	static Scanner sc = new Scanner(System.in);
	static boolean flag = false;
	static boolean isUser = false;

	// books lists
	static List<Book> books = Utilities.generateBooks();

	// mono user
	static User user;

	// selections menu
	static String guestMenu = "Benvenuto GUEST, cosa vuoi fare?\n1 - Acquista un libro\n2 - Mostra la tua lista\n3 - Accedi alla ADMIN DASHBOARD";
	static String adminMenu = "Benvenuto ADMIN, cosa vuoi fare?\n1 - Aggiungi un libro\n2 - Rimuovi un libro\n3 - Modifica un libro\n4 - Uscire";
	static String finalMenu = "\n******** Scrivi\n1 - Continua \n2 - Termina Esecuzione";

	// start shop
	public static void startShop() {

		while (!flag) {
			try {
				
				generateUser();
				
				if (user.getRole().equals("guest")) {
					int guestChoice = Utilities.userInput(Integer.class, guestMenu);
					guestMenu(guestChoice);
				}

				if (user.getRole().equals("admin")) {
					int adminChoice = Utilities.userInput(Integer.class, adminMenu);
					adminMenu(adminChoice);
				}

				int finalChoice = Utilities.userInput(Integer.class, finalMenu);
				finalMenu(finalChoice);

			} catch (Exception e) {
				System.err.println(e);
				startShop();
			}

		}
	}

	private static void guestMenu(int choice) {
		switch (choice) {
		case 1:
			Utilities.buyBook(books, user.getBooks());
			break;
		case 2:
			Utilities.showBooks(user.getBooks());
			break;
		case 3:
			String psw = Utilities.userInput(String.class, "** Inserisci la PSW **");

			while (!psw.equals(PASSWORD)) {
				psw = Utilities.userInput(String.class, "Password errata, riprova");
			}

			user.setRole("admin");
			break;
		}
	}

	private static void adminMenu(int choice) {
		switch (choice) {
		case 1:
			Utilities.addBook(books);
			break;
		case 2:
			Utilities.removeBook(books);
			break;
		case 3:
			Utilities.modifyBook(books);
			break;
		case 4:
			user.setRole("guest");
			startShop();
		}
	}

	private static void finalMenu(int choice) {
		if (choice == 2) flag = true;
	}
	
	private static void generateUser() {
		if(!isUser) {
			user = new User();
			isUser = true;
		} else {
			int userChoice = Utilities.userInput(Integer.class, "Seleziona:\n1 - Continuare la sessione\n2 - Uscire e creare un nuovo utente");
			if(userChoice == 2) user = new User();
		}
	}
}
