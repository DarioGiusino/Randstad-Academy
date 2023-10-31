import java.util.*;

public class StazioneMeteo {
	
	private MeteoInfo info;
	private ArrayList<Osservatore> osservatori;
	
	public StazioneMeteo() {
		osservatori = new ArrayList<Osservatore>();
	}
	
	public void aggiungiOsservatore(Osservatore osservatore) {
		osservatori.add(osservatore);
	}
	public void rimuoviOsservatore(Osservatore osservatore) {
		osservatori.remove(osservatore);
	}
	private void aggiornaOsservatori() {
		for(Osservatore oss : osservatori)
			oss.refreshMeteo(info);
	}
	
	public void aggiornaMeteo(MeteoInfo info) {
		if(this.info == null)
			this.info = new MeteoInfo(info);
		else 
			this.info.aggiornaInfo(info);
		
		aggiornaOsservatori();
	}
}
