package org.bl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.pojo.User;
import org.utils.ConnectionUtils;
import org.utils.Utilities;

public class Shop {
	// utilities
	static final String PASSWORD = "password";
	static Scanner sc = new Scanner(System.in);
	static boolean flag = false;
	static boolean isUser = false;
	static ConnectionUtils conn;

	static List<Integer> cart = new ArrayList<>();

	// mono user
	static User user;

	// selections menu
	static String guestMenu = "Benvenuto GUEST, cosa vuoi fare?\n1 - Visualizza catalogo\n2 - Mostra il tuo carrello\n3 - Accedi alla ADMIN DASHBOARD";
	static String adminMenu = "Benvenuto ADMIN, cosa vuoi fare?\n1 - Gestisci prodotti\n2 - Gestisci clienti\n3 - Gestisci ordini\n4 - Uscire";
	static String finalMenu = "\n******** Scrivi\n1 - Continua \n2 - Termina Esecuzione";

	// start shop
	public static void startShop() throws SQLException {
		conn = new ConnectionUtils("root", "root", "negozio_db");

		while (!flag) {
			try {

				generateUser();

				if (user.getRole().equals("guest")) {
					int guestChoice = Utilities.userInput(Integer.class, guestMenu);
					guestMenu(guestChoice, conn);
				}

				if (user.getRole().equals("admin")) {
					int adminChoice = Utilities.userInput(Integer.class, adminMenu);
					adminMenu(adminChoice, conn);
				}

				int finalChoice = Utilities.userInput(Integer.class, finalMenu);
				finalMenu(finalChoice);

			} catch (Exception e) {
				System.err.println(e);
				startShop();
			}

		}

		conn.close();
		sc.close();
	}

	private static void guestMenu(int choice, ConnectionUtils conn) throws SQLException {
		switch (choice) {
		case 1:
			ResultSet rs = conn.getPreparedResultSet("prodotto");
			conn.printResultSet(rs);
			Integer userChoice = Utilities.userInput(Integer.class,
					"Inserisci il numero della RIGA del prodotto che vuoi acquistare o un altro numero per continuare.");

			Integer columnCount = rs.getMetaData().getColumnCount();

			if (userChoice > 0 || userChoice <= columnCount) {
				cart.add(userChoice);
			}

			finalMenu(1);

			break;
		case 2:
			String s = "";
			for (int i = 0; i < cart.size(); i++) {
				s += "prodotto.IDprodotto = " + cart.get(i) + (i == cart.size() - 1 ? "" : " OR ");
			}
			ResultSet rs1 = conn.getStaticResultSet("SELECT * FROM prodotto WHERE " + s);

			conn.printResultSet(rs1);

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

	private static void adminMenu(int choice, ConnectionUtils conn) throws SQLException {
		switch (choice) {
		case 1:
			Utilities.manageItem("prodotto", conn);
			break;
		case 2:
			Utilities.manageItem("cliente", conn);
			break;
		case 3:
			Utilities.manageItem("ordine", conn);
			break;
		case 4:
			user.setRole("guest");
			startShop();
		}
	}

	private static void finalMenu(int choice) {
		if (choice == 2)
			flag = true;
	}

	private static void generateUser() {
		if (!isUser) {
			user = new User();
			isUser = true;
		} else {
			int userChoice = Utilities.userInput(Integer.class,
					"Seleziona:\n1 - Continuare la sessione\n2 - Uscire e creare un nuovo utente");
			if (userChoice == 2)
				user = new User();
		}
	}
}
