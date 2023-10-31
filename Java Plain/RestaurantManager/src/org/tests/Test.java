package org.tests;

import org.services.PrenotazioneServiceImpl;

/*
 * Classe dove testare le varie implementazioni e funzioni dell'applicazione.
*/

public class Test {
	public static void main(String[] args) {
		PrenotazioneServiceImpl psi = new PrenotazioneServiceImpl();
		
		psi.startRestaurantManager();
	}
}
