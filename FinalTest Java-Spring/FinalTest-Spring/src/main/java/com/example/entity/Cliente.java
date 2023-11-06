package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Rappresenta l'entità Cliente.
 */
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;

    public Cliente() {
    }

    /**
     * Costruttore per creare un'istanza di Cliente con parametri inizializzati.
     *
     * @param id      ID del cliente.
     * @param nome    Nome del cliente.
     * @param cognome Cognome del cliente.
     */
    public Cliente(Long id, String nome, String cognome) {
        super();
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
    }

    /**
     * Restituisce l'ID del cliente.
     *
     * @return ID del cliente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Imposta l'ID del cliente.
     *
     * @param id ID del cliente.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Restituisce il nome del cliente.
     *
     * @return Nome del cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome del cliente.
     *
     * @param nome Nome del cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il cognome del cliente.
     *
     * @return Cognome del cliente.
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta il cognome del cliente.
     *
     * @param cognome Cognome del cliente.
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
}
