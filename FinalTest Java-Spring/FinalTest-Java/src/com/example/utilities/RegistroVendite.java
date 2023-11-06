package com.example.utilities;

import com.example.entities.Cliente;
import com.example.entities.Giocattolo;


/**
 * La classe astratta RegistroVendite gestisce la registrazione e la visualizzazione delle vendite dei giocattoli.
 */
public abstract class RegistroVendite {

    /**
     * Registra la vendita di un giocattolo da parte di un cliente.
     *
     * @param giocattolo Il giocattolo venduto.
     * @param cliente Il cliente che ha effettuato l'acquisto.
     */
	public abstract void registraVendita(Giocattolo giocattolo, Cliente cliente);
	
    /**
     * Visualizza le informazioni sulle vendite effettuate.
     */
	public abstract void visualizzaVendite();
}
