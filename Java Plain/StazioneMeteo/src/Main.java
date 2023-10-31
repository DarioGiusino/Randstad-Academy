import java.util.*;

public class Main {

	public static void main(String[] args) {
		StazioneMeteo stazione = new StazioneMeteo();

		Operatore op1 = new Operatore("Pippo");
		Operatore op2 = new Operatore("Geppetto");
		Operatore op3 = new Operatore("Antonio");
		Veicolo veicolo = new Veicolo("Furgone AC03");
		
		stazione.aggiungiOsservatore(op1);
		stazione.aggiungiOsservatore(op2);
		stazione.aggiungiOsservatore(op3);
		stazione.aggiungiOsservatore(veicolo);
		
		MeteoInfo nuovoMeteo = new MeteoInfo(30, 15, new Date(), Regione.Campania);
		
		stazione.aggiornaMeteo(nuovoMeteo);
		
		op1.mostraInfo();
		op2.mostraInfo();
		op3.mostraInfo();
		veicolo.mostraInfo();
	}
}