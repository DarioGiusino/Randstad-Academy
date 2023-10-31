package org.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Utilities {

	public static <T> T userInput(Class<T> type, String s) {
		Scanner sc = new Scanner(System.in);
		System.out.println(s);

		if (type == Integer.class) {
			int userInput = sc.nextInt();
			return type.cast(userInput);

		} else if (type == Double.class) {
			double userInput2 = sc.nextDouble();
			return type.cast(userInput2);

		} else if (type == String.class) {
			String userInput3 = sc.next();
			return type.cast(userInput3);

		} else if (type == Float.class) {
			Float userInput4 = sc.nextFloat();
			return type.cast(userInput4);
		} else {
			throw new IllegalArgumentException("Tipo non supportato: " + type.getSimpleName());
		}
	}

	public static void manageItem(String item, ConnectionUtils conn) throws SQLException {
		Integer adminChoice;
		String editColumn;
		String s = "";
		item.toLowerCase();

		ResultSet rs = conn.getPreparedResultSet(item);

		adminChoice = Utilities.userInput(Integer.class,
				"Inserisci:\n1 - Aggiungi " + item + "\n2 - Modifica " + item + "\n3 - Rimuovi " + item);
		switch (adminChoice) {
		case 1:
			rs.moveToInsertRow();
			if (item.equals("prodotto")) {
				String brand = Utilities.userInput(String.class, "Inserisci la marca del prodotto: ");
				String model = Utilities.userInput(String.class, "Inserisci il modello del prodotto: ");
				String desc = Utilities.userInput(String.class, "Inserisci la descrizione del prodotto: ");
				Float price = Utilities.userInput(Float.class, "Inserisci il prezzo del prodotto: ");
				Integer qta = Utilities.userInput(Integer.class, "Inserisci la quantita del prodotto: ");
				rs.updateString("marca", brand);
				rs.updateString("modello", model);
				rs.updateString("descrizione", desc);
				rs.updateFloat("prezzo", price);
				rs.updateInt("qta", qta);

			} else if (item.equals("cliente")) {
				String mail = Utilities.userInput(String.class, "Inserisci la mail del cliente: ");
				String username = Utilities.userInput(String.class, "Inserisci username del cliente: ");
				String name = Utilities.userInput(String.class, "Inserisci il nomee del cliente: ");
				String surname = Utilities.userInput(String.class, "Inserisci il cognome del cliente: ");
				String address = Utilities.userInput(String.class, "Inserisci indirizzo del cliente: ");
				rs.updateString("marca", mail);
				rs.updateString("modello", username);
				rs.updateString("descrizione", name);
				rs.updateString("marca", surname);
				rs.updateString("modello", address);

			} else if (item.equals("ordine")) {
				ResultSet rs1 = conn.getPreparedResultSet("cliente");
				conn.printResultSet(rs1);

				Integer IDmail = Utilities.userInput(Integer.class,
						"Inserisci il numero della RIGA del cliente relativo all ordine: ");

				rs1.absolute(IDmail);
				String mail = (String) rs1.getString(IDmail);

				Date date = new Date();
				Date sqlDate = new java.sql.Date(date.getTime());
				Float totPrice = Utilities.userInput(Float.class, "Inserisci il costo totale dell ordine: ");
				rs.updateString("emailCliente", mail);
				rs.updateDate("dataOrdine", (java.sql.Date) sqlDate);
				rs.updateFloat("costoTotale", totPrice);
			}

			rs.insertRow();

			System.out.println("** " + item + " aggiunto/a con successo **");

			rs.moveToCurrentRow();
			break;

		case 2:
			conn.printResultSet(rs);
			adminChoice = Utilities.userInput(Integer.class, "Inserisci il numero della RIGA da modificare: ");
			rs.absolute(adminChoice);
			editColumn = Utilities.userInput(String.class, "Scrivi il nome della colonna che vuoi modificare: ")
					.toLowerCase();

			List<String> words = Arrays.asList("marca", "modello", "descrizione", "emailcliente", "username", "nome",
					"cognome", "indirizzo");
			List<String> nums = Arrays.asList("prezzo", "costototale");

			if (words.contains(editColumn)) {
				s = Utilities.userInput(String.class, "Inserisci il nuovo valore: ");
				rs.updateString(editColumn, s);
				rs.updateRow();

			} else if (nums.contains(editColumn)) {
				Float f = Utilities.userInput(Float.class, "Inserisci il nuovo valore: ");
				rs.updateFloat(editColumn, f);
				rs.updateRow();
			} else {
				Integer i = Utilities.userInput(Integer.class, "Inserisci il nuovo valore: ");
				rs.updateInt(editColumn, i);
				rs.updateRow();
			}

			System.out.println("** " + editColumn + " aggiornato/a con successo **");

			break;

		case 3:
			conn.printResultSet(rs);
			adminChoice = Utilities.userInput(Integer.class, "Inserisci il numero della RIGA da cancellare: ");
			rs.absolute(adminChoice);
			rs.deleteRow();
			System.out.println("** Item con ID " + adminChoice + " cancellato con successo **");
			break;
		}
	}
}
