package org.models;

/*
 * Classe che descrive proprietà e metodi dell'entità tavolo
*/

public class Tavolo {
	private Integer id;
	private Integer numeroPosti;
	private Boolean stato;

	public Tavolo(Integer id, Integer numeroPosti, Boolean stato) {
		setId(id);
		setNumeroPosti(numeroPosti);
		setStato(stato);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(Integer numeroPosti) {
		this.numeroPosti = numeroPosti;
	}

	public Boolean getStato() {
		return stato;
	}

	public void setStato(Boolean stato) {
		this.stato = stato;
	}
	
	@Override
	public String toString() {
		String s = "[ "+getId()+" ] Posti: " + getNumeroPosti() + " - Stato: " + (getStato() == true ? "Y" : "N");
		return s;
	}

}
