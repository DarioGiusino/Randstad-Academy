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

import com.example.entity.Prodotto;
import com.example.serv.ProdottoServ;

/**
 * Il controller ProdottoController gestisce le operazioni REST per l'entità Prodotto.
 */
@RestController
@RequestMapping("/prodotto")
public class ProdottoController {

    @Autowired
    private ProdottoServ servizioServ;

    /**
     * Restituisce una lista di tutti i prodotti.
     *
     * @return Lista di prodotti.
     */
    @GetMapping
    public List<Prodotto> findAll() {
        return servizioServ.findAll();
    }

    /**
     * Trova un prodotto per ID.
     *
     * @param id ID del prodotto da cercare.
     * @return Il prodotto trovato (o vuoto se non presente).
     */
    @GetMapping("/{id}")
    public Optional<Prodotto> findById(@PathVariable Long id) {
        return servizioServ.findById(id);
    }

    /**
     * Salva un nuovo prodotto.
     *
     * @param servizio Il prodotto da salvare.
     * @return Il prodotto salvato.
     */
    @PostMapping
    public Prodotto save(@RequestBody Prodotto servizio) {
        return servizioServ.save(servizio);
    }

    /**
     * Aggiorna un prodotto esistente per ID.
     *
     * @param id       ID del prodotto da aggiornare.
     * @param servizio Dati del prodotto per l'aggiornamento.
     * @return Il prodotto aggiornato (o null se non esiste).
     */
    @PutMapping("/{id}")
    public Prodotto update(@PathVariable Long id, @RequestBody Prodotto servizio) {
        Prodotto c = servizioServ.findById(id).orElse(null);

        if (c != null) {
            c.setNome(servizio.getNome() == null ? c.getNome() : servizio.getNome());
            c.setPrezzo(servizio.getPrezzo() == null ? c.getPrezzo() : servizio.getPrezzo());
            c.setQta(servizio.getQta() == null ? c.getQta() : servizio.getQta());
            c.setOrdine(servizio.getOrdine() == null ? c.getOrdine() : servizio.getOrdine());

            servizioServ.save(c);
            return c;
        }

        return null;
    }

    /**
     * Elimina un prodotto per ID.
     *
     * @param id ID del prodotto da eliminare.
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        servizioServ.deleteById(id);
    }
}
