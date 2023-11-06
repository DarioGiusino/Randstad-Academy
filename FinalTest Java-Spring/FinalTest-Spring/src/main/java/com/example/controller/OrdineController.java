package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Ordine;
import com.example.serv.OrdineServ;

/**
 * Il controller OrdineController gestisce le operazioni REST per l'entità Ordine.
 */
@RestController
@RequestMapping("/ordine")
public class OrdineController {

    @Autowired
    private OrdineServ ordineServ;

    /**
     * Restituisce una lista di tutti gli ordini.
     *
     * @return Lista di ordini.
     */
    @GetMapping
    public List<Ordine> findAll() {
        return ordineServ.findAll();
    }

    /**
     * Trova un ordine per ID.
     *
     * @param id ID dell'ordine da cercare.
     * @return L'ordine trovato (o vuoto se non presente).
     */
    @GetMapping("/{id}")
    public Optional<Ordine> findById(@PathVariable Long id) {
        return ordineServ.findById(id);
    }

    /**
     * Salva un nuovo ordine.
     *
     * @param ordine L'ordine da salvare.
     * @return L'ordine salvato.
     */
    @PostMapping
    public Ordine save(@RequestBody Ordine ordine) {
        return ordineServ.save(ordine);
    }

    /**
     * Aggiorna un ordine esistente per ID.
     *
     * @param id      ID dell'ordine da aggiornare.
     * @param ordine  Dati dell'ordine per l'aggiornamento.
     * @return L'ordine aggiornato (o null se non esiste).
     */
    @PutMapping("/{id}")
    public Ordine update(@PathVariable Long id, @RequestBody Ordine ordine) {
        Ordine c = ordineServ.findById(id).orElse(null);

        if (c != null) {
            c.setCliente(ordine.getCliente() == null ? c.getCliente() : ordine.getCliente());
            c.setProdotti(ordine.getProdotti() == null ? c.getProdotti() : ordine.getProdotti());

            ordineServ.save(c);
            return c;
        }

        return null;
    }

    /**
     * Elimina un ordine per ID.
     *
     * @param id ID dell'ordine da eliminare.
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        ordineServ.deleteById(id);
    }
}
