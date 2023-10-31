package org.lessons;

import java.sql.ResultSet;
import java.sql.SQLException;

//In base al database Negozio, creare un client che permette l’inserimento di nuovi prodotti, di nuovi clienti, di nuovi ordini
//e la gestione di questi(ovvero update ed eliminazione righe).
//
//Permettere ad un eventuale utente la visualizzazione del catalogo e l’acquisto di diversi prodotti per un ordine, 
//quindi un carrello e una cronologia ordini.

public class Main {
	public static void main(String[] args) throws SQLException {
		ConnectionUtils conn = new ConnectionUtils("root", "root", "negozio_db");

//		String query = "SELECT * FROM city WHERE population > 8000000";
		String query = "SELECT * FROM prodotto";
//		String query = "SELECT COUNT(*) AS Conteggio FROM city";
		ResultSet rs = conn.getResultSet(query);

		conn.printResultSet(rs);
		conn.close();
	}
}
