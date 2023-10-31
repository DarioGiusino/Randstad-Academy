package org.models;

import java.sql.Time;
import java.util.Date;

/*
 * Classe che descrive proprietà e metodi dell'entità prenotazione
*/

public class Prenotazione {
	private Integer id;
	private Date data;
	private Time orario;
	private Integer numeroPersone;
	private Tavolo tavolo;

	public Prenotazione(Integer id, Date data, Time orario, Integer numeroPersone, Tavolo tavolo) {
		setId(id);
		setData(data);
		setOrario(orario);
		setNumeroPersone(numeroPersone);
		setTavolo(tavolo);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getOrario() {
		return orario;
	}

	public void setOrario(Time orario) {
		this.orario = orario;
	}

	public Integer getNumeroPersone() {
		return numeroPersone;
	}

	public void setNumeroPersone(Integer numeroPersone) {
		this.numeroPersone = numeroPersone;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

}
