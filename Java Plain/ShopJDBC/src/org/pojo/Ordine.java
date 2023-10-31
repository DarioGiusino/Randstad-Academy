package org.pojo;

import java.util.Date;

public class Ordine {

	private Integer idOrdine;
	private String emailCliente;
	private Date dataOrdine;
	private Float costoTotale;

	public Ordine(Integer idOrdine, String emailCliente, Date dataOrdine, Float costoTotale) {
		this.idOrdine = idOrdine;
		this.emailCliente = emailCliente;
		this.dataOrdine = dataOrdine;
		this.costoTotale = costoTotale;
	}

	public Integer getIdOrdine() {
		return idOrdine;
	}

	public void setIdOrdine(Integer iDordine) {
		idOrdine = iDordine;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public Date getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(Date dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	public Float getCostoTotale() {
		return costoTotale;
	}

	public void setCostoTotale(Float costoTotale) {
		this.costoTotale = costoTotale;
	}

}
