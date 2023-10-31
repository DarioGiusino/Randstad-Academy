package org.pojo;

public class Prodotto {
	private Integer idProdotto;
	private String marca;
	private String modello;
	private String descrizione;
	private Float prezzo;
	private Integer qta;

	public Prodotto(Integer idProdotto, String marca, String modello, String descrizione, Float prezzo, Integer qta) {
		this.idProdotto = idProdotto;
		this.marca = marca;
		this.modello = modello;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.qta = qta;
	}

	public Integer getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(Integer idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getQta() {
		return qta;
	}

	public void setQta(Integer qta) {
		this.qta = qta;
	}

}
