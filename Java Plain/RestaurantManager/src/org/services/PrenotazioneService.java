package org.services;

/*
 * Interfaccia che definisce i metodi che deve avere un'implementazione del servizio di prenotazione.
*/

public interface PrenotazioneService {
	public void prenotaTavolo();
	
	public void annullaPrenotazione();
	
	public void getTavoliDisponibili();
}
