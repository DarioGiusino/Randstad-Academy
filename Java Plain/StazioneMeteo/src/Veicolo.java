
public class Veicolo implements Osservatore{
	private String modello;
	private MeteoInfo info;
	
	public Veicolo(String modello) {
		this.modello = modello;
	}
	
	public void refreshMeteo(MeteoInfo info) {
		this.info = new MeteoInfo(info);
	}
	
	public void mostraInfo() {
		if(info == null) return;
		
		System.out.println("Ultimo aggiornamento meteo per  " + modello + " il " + info.getUltimoAggiornamento());
	}
}
