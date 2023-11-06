package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.entities.Cliente;
import com.example.entities.Giocattolo;
import com.example.utilities.RegistroVendite;
import com.example.utilities.Utilities;


/**
 * La classe Menu gestisce l'interfaccia utente per un negozio di giocattoli.
 */
public class Menu extends RegistroVendite {
	private Boolean isStarted = true;
	private Inventario inventario = new Inventario();
	private List<Vendita> vendite = new ArrayList<>();
	private Cliente cliente = new Cliente(1L, "cliente1", "indirizzo1", "mario@email.com");

	
    /**
     * Avvia il negozio e permette all'utente di interagire con il sistema.
     */
	public void startNegozio() {

		while (isStarted) {
			Integer choice = Utilities.userInput(Integer.class,
					"Benvenuto:" + "\n1 - Compra un giocattolo" + "\n2 - Accedi all'inventario" + "\n3 - Esci");

			switch (choice) {
			case 1:
				guestMenu();
				break;
			case 2:
				adminMenu();
				break;
			case 3:
				System.out.println("** Arrivederci e grazie... **");
				isStarted = !isStarted;
				break;
			default:
				startNegozio();
			}
		}
	}

	
    /**
     * Menu per il cliente che desidera acquistare un giocattolo.
     */
	public void guestMenu() {
		System.out.println(inventario.toString());

		Long idToy = Utilities.userInput(Long.class, "Inserisci l'id del giocattolo da acquistare: ");

		boolean giocattoloTrovato = false; // Flag per segnalare se è stato trovato il giocattolo

		for (Giocattolo giocattolo : inventario.getListaGiocattoli()) {
			if (giocattolo.getId() == idToy) {
				// Se l'ID corrisponde, rimuovi il giocattolo, registra la vendita e segnala che
				// è stato trovato
				inventario.getListaGiocattoli().remove(giocattolo);
				System.out.println("Giocattolo acquistato con successo!");
				registraVendita(giocattolo, cliente);
				giocattoloTrovato = true;
				break;
			}
		}

		if (!giocattoloTrovato) {
			System.err.println("Nessun giocattolo con questo ID, riprova");
		}

	}

	
    /**
     * Menu per l'amministratore per gestire l'inventario e visualizzare le vendite.
     */
	public void adminMenu() {
		Integer choice = Utilities.userInput(Integer.class, "Benvenuto:" + "\n1 - aggiungi un giocattolo"
				+ "\n2 - Visualizza lista Vendite" + "\n3 - Visualizza lista giocattoli" + "\n4 - Esci");

		switch (choice) {
		case 1:
			String nomeToy = Utilities.userInput(String.class, "Inserisci il nuovo nome del giocattolo: ");
			Double prezzoToy = Utilities.userInput(Double.class, "inserisci il prezzo del giocattolo: ");
			Integer etaToy = Utilities.userInput(Integer.class, "inserisci l eta consigliata del giocattolo: ");

			Random random = new Random();
			Long idCasuale = random.nextLong();

			Giocattolo g = new Giocattolo(idCasuale, nomeToy, prezzoToy, etaToy);
			inventario.getListaGiocattoli().add(g);

			System.out.println("giocattolo aggiunto con successo");

			break;
		case 2:
			visualizzaVendite();
			adminMenu();
			break;
		case 3:
			System.out.println(inventario.toString());
			break;
		case 4:
			System.out.println("** Arrivederci e grazie... **");
			isStarted = !isStarted;
			break;
		default:
			adminMenu();
		}

	}

	
    // Implementazioni dei metodi astratti dalla classe RegistroVendite

    /**
     * Registra una vendita di un giocattolo da parte di un cliente.
     *
     * @param giocattolo Il giocattolo acquistato.
     * @param cliente Il cliente che ha effettuato l'acquisto.
     */
	@Override
	public void registraVendita(Giocattolo giocattolo, Cliente cliente) {
		Vendita nuovaVendita = new Vendita(giocattolo, cliente);
		vendite.add(nuovaVendita);
	}
	
    /**
     * Visualizza le vendite registrate.
     */
	@Override
	public void visualizzaVendite() {
		for (Vendita vendita : vendite) {
			System.out.println("Cliente: " + vendita.getCliente().getNome() + ", ha acquistato il giocattolo: "
					+ vendita.getGiocattolo().getNome());
		}
	}

}
