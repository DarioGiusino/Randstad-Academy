package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * Rappresenta l'entità Prodotto.
 */
@Entity
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double prezzo;
    private Integer qta;

    @ManyToOne
    private Ordine ordine;

    public Prodotto() {
    }

    /**
     * Costruttore per creare un'istanza di Prodotto con tutti i parametri.
     *
     * @param id     ID del prodotto.
     * @param nome   Nome del prodotto.
     * @param prezzo Prezzo del prodotto.
     * @param qta    Quantità disponibile del prodotto.
     * @param ordine Ordine associato al prodotto.
     */
    public Prodotto(Long id, String nome, Double prezzo, Integer qta, Ordine ordine) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.qta = qta;
        this.ordine = ordine;
    }

    /**
     * Costruttore per creare un'istanza di Prodotto senza associarlo a un ordine.
     *
     * @param id     ID del prodotto.
     * @param nome   Nome del prodotto.
     * @param prezzo Prezzo del prodotto.
     * @param qta    Quantità disponibile del prodotto.
     */
    public Prodotto(Long id, String nome, Double prezzo, Integer qta) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.qta = qta;
    }

    /**
     * Restituisce l'ID del prodotto.
     *
     * @return ID del prodotto.
     */
    public Long getId() {
        return id;
    }

    /**
     * Imposta l'ID del prodotto.
     *
     * @param id ID del prodotto.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Restituisce il nome del prodotto.
     *
     * @return Nome del prodotto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome del prodotto.
     *
     * @param nome Nome del prodotto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il prezzo del prodotto.
     *
     * @return Prezzo del prodotto.
     */
    public Double getPrezzo() {
        return prezzo;
    }

    /**
     * Imposta il prezzo del prodotto.
     *
     * @param prezzo Prezzo del prodotto.
     */
    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    /**
     * Restituisce la quantità disponibile del prodotto.
     *
     * @return Quantità disponibile del prodotto.
     */
    public Integer getQta() {
        return qta;
    }

    /**
     * Imposta la quantità disponibile del prodotto.
     *
     * @param qta Quantità disponibile del prodotto.
     */
    public void setQta(Integer qta) {
        this.qta = qta;
    }

    /**
     * Restituisce l'ordine associato al prodotto.
     *
     * @return Ordine associato al prodotto.
     */
    public Ordine getOrdine() {
        return ordine;
    }

    /**
     * Imposta l'ordine associato al prodotto.
     *
     * @param ordine Ordine associato al prodotto.
     */
    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

}
