package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 * Rappresenta l'entità Ordine.
 */
@Entity
public class Ordine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @OneToMany
    private List<Prodotto> prodotti = new ArrayList<>();

    public Ordine() {
    }

    /**
     * Costruttore per creare un'istanza di Ordine con parametri inizializzati.
     *
     * @param id       ID dell'ordine.
     * @param cliente  Cliente associato all'ordine.
     * @param prodotti Lista di prodotti dell'ordine.
     */
    public Ordine(Long id, Cliente cliente, List<Prodotto> prodotti) {
        super();
        this.id = id;
        this.cliente = cliente;
        this.prodotti = prodotti;
    }

    /**
     * Restituisce l'ID dell'ordine.
     *
     * @return ID dell'ordine.
     */
    public Long getId() {
        return id;
    }

    /**
     * Imposta l'ID dell'ordine.
     *
     * @param id ID dell'ordine.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Restituisce il cliente associato all'ordine.
     *
     * @return Cliente associato all'ordine.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Imposta il cliente associato all'ordine.
     *
     * @param cliente Cliente associato all'ordine.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Restituisce la lista dei prodotti dell'ordine.
     *
     * @return Lista dei prodotti dell'ordine.
     */
    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    /**
     * Imposta la lista dei prodotti dell'ordine.
     *
     * @param prodotti Lista dei prodotti dell'ordine.
     */
    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

}
