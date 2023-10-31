
public class Operatore implements Osservatore{

	private String nome;
	private MeteoInfo info;
	
	public Operatore(String nome) {
		this.nome = nome;
	}
	
	public void refreshMeteo(MeteoInfo info) {
		this.info = new MeteoInfo(info);
	}
	
	public void mostraInfo() {
		if(info == null) return;
		
		System.out.println(nome + " fa caldo? " + info.getTemperatura());
	}
}