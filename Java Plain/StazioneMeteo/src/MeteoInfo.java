import java.util.Date;

public class MeteoInfo {
	private int temperatura;
	private float speedVento;
	private Date ultimoAggiornamento;
	private Regione regione;

	public int getTemperatura() {
		return temperatura;
	}
	public float getSpeedVento() {
		return speedVento;
	}
	public Date getUltimoAggiornamento() {
		return ultimoAggiornamento;
	}
	public Regione getRegione() {
		return regione;
	}

	public MeteoInfo(int temperatura, float speedVento, Date ultimoAggiornamento, Regione regione) {
		aggiornaInfo(temperatura, speedVento, ultimoAggiornamento, regione);
	}
	public MeteoInfo(MeteoInfo info) {
		aggiornaInfo(info);
	}
	
	public void aggiornaInfo(int temperatura, float speedVento, Date ultimoAggiornamento, Regione regione) {
		this.temperatura = temperatura;
		this.speedVento = speedVento;
		this.ultimoAggiornamento = ultimoAggiornamento;
		this.regione = regione;
	}
	public void aggiornaInfo(MeteoInfo info) {
		aggiornaInfo(info.getTemperatura(), info.getSpeedVento(), info.getUltimoAggiornamento(), info.getRegione());
	}
}