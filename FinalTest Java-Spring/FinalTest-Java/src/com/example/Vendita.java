package com.example;

import com.example.entities.Cliente;
import com.example.entities.Giocattolo;

/**
 * La classe Vendita rappresenta un'istanza di vendita di un giocattolo a un cliente.
 */
public class Vendita {
	private Cliente cliente;
	private Giocattolo giocattolo;
	
    /**
     * Costruisce un'istanza di Vendita con il giocattolo venduto e il cliente che ha effettuato l'acquisto.
     *
     * @param giocattolo Il giocattolo venduto.
     * @param cliente Il cliente che ha effettuato l'acquisto.
     */
	public Vendita(Giocattolo giocattolo, Cliente cliente) {
		this.cliente = cliente;
		this.giocattolo = giocattolo;
	}
	
    /**
     * Restituisce il cliente coinvolto nella vendita.
     *
     * @return Il cliente coinvolto nella vendita.
     */
	public Cliente getCliente() {
		return cliente;
	}
	
    /**
     * Imposta il cliente coinvolto nella vendita.
     *
     * @param cliente Il cliente da impostare per la vendita.
     */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
    /**
     * Restituisce il giocattolo venduto nella vendita.
     *
     * @return Il giocattolo venduto.
     */
	public Giocattolo getGiocattolo() {
		return giocattolo;
	}

	
    /**
     * Imposta il giocattolo venduto nella vendita.
     *
     * @param giocattolo Il giocattolo da impostare per la vendita.
     */
	public void setGiocattolo(Giocattolo giocattolo) {
		this.giocattolo = giocattolo;
	}

	
	
}
