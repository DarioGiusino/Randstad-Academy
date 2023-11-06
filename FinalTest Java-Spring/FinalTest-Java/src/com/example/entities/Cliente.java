package com.example.entities;

/**
 * La classe Cliente rappresenta un cliente del negozio.
 */
public class Cliente {
	private Long id;
	private String nome;
	private String indirizzo;
	private String email;

	/**
	 * Costruisce un oggetto Cliente con l'ID, il nome, l'indirizzo e l'email
	 * specificati.
	 *
	 * @param id        L'identificatore univoco del cliente.
	 * @param nome      Il nome del cliente.
	 * @param indirizzo L'indirizzo del cliente.
	 * @param email     L'email del cliente.
	 */
	public Cliente(Long id, String nome, String indirizzo, String email) {
		this.id = id;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.email = email;
	}

	/**
	 * Restituisce l'ID del cliente.
	 *
	 * @return L'ID del cliente.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Imposta l'ID del cliente.
	 *
	 * @param id L'ID del cliente da impostare.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Restituisce il nome del cliente.
	 *
	 * @return Il nome del cliente.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Imposta il nome del cliente.
	 *
	 * @param nome Il nome del cliente da impostare.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Restituisce l'indirizzo del cliente.
	 *
	 * @return L'indirizzo del cliente.
	 */
	public String getIndirizzo() {
		return indirizzo;
	}

	/**
	 * Imposta l'indirizzo del cliente.
	 *
	 * @param indirizzo L'indirizzo del cliente da impostare.
	 */
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	/**
	 * Restituisce l'email del cliente.
	 *
	 * @return L'email del cliente.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Imposta l'email del cliente.
	 *
	 * @param email L'email del cliente da impostare.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
