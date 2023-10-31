package org.bl;

import java.sql.SQLException;

//In base al database Negozio, creare un client che permette l’inserimento di nuovi prodotti, di nuovi clienti, di nuovi ordini
//e la gestione di questi(ovvero update ed eliminazione righe).
//
//Permettere ad un eventuale utente la visualizzazione del catalogo e l’acquisto di diversi prodotti per un ordine, 
//quindi un carrello e una cronologia ordini.

public class Main {
	public static void main(String[] args) throws SQLException {
		Shop.startShop();
	}
}
