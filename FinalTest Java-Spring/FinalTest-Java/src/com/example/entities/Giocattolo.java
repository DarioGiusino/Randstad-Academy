package com.example.entities;

/**
 * La classe Giocattolo rappresenta un giocattolo disponibile nel negozio.
 */
public class Giocattolo {
	private Long id;
	private String nome;
	private Double prezzo;
	private Integer etaConsigliata;

	/**
	 * Costruisce un oggetto Giocattolo con l'ID, il nome, il prezzo e l'età
	 * consigliata specificati.
	 *
	 * @param id             L'identificatore univoco del giocattolo.
	 * @param nome           Il nome del giocattolo.
	 * @param prezzo         Il prezzo del giocattolo.
	 * @param etaConsigliata L'età consigliata per il giocattolo.
	 */
	public Giocattolo(Long id, String nome, Double prezzo, Integer etaConsigliata) {
		this.id = id;
		this.nome = nome;
		this.prezzo = prezzo;
		this.etaConsigliata = etaConsigliata;
	}

	/**
	 * Restituisce l'ID del giocattolo.
	 *
	 * @return L'ID del giocattolo.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Imposta l'ID del giocattolo.
	 *
	 * @param id L'ID del giocattolo da impostare.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Restituisce il nome del giocattolo.
	 *
	 * @return Il nome del giocattolo.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Imposta il nome del giocattolo.
	 *
	 * @param nome Il nome del giocattolo da impostare.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Restituisce il prezzo del giocattolo.
	 *
	 * @return Il prezzo del giocattolo.
	 */
	public Double getPrezzo() {
		return prezzo;
	}

	/**
	 * Imposta il prezzo del giocattolo.
	 *
	 * @param prezzo Il prezzo del giocattolo da impostare.
	 */
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * Restituisce l'età consigliata per il giocattolo.
	 *
	 * @return L'età consigliata per il giocattolo.
	 */
	public Integer getEtaConsigliata() {
		return etaConsigliata;
	}

	/**
	 * Imposta l'età consigliata per il giocattolo.
	 *
	 * @param etaConsigliata L'età consigliata per il giocattolo da impostare.
	 */
	public void setEtaConsigliata(Integer etaConsigliata) {
		this.etaConsigliata = etaConsigliata;
	}

	/**
	 * Restituisce una stringa rappresentante le informazioni del giocattolo.
	 *
	 * @return Una stringa con le informazioni sull'ID, il nome, il prezzo e l'età
	 *         consigliata del giocattolo.
	 */
	@Override
	public String toString() {
		return "ID: " + getId() + " | Nome: " + getNome() + " | Prezzo: " + getPrezzo() + " | EtaConsigliata: "
				+ getEtaConsigliata() + "\n";
	}

}
