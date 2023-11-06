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

import com.example.entity.Cliente;
import com.example.serv.ClienteServ;

/**
 * Il controller ClienteController gestisce le operazioni REST per l'entità
 * Cliente.
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteServ clienteServ;

	/**
	 * Restituisce una lista di tutti i clienti.
	 *
	 * @return Lista di clienti.
	 */
	@GetMapping
	public List<Cliente> findAll() {
		return clienteServ.findAll();
	}

	/**
	 * Trova un cliente per ID.
	 *
	 * @param id ID del cliente da cercare.
	 * @return Il cliente trovato (o vuoto se non presente).
	 */
	@GetMapping("/{id}")
	public Optional<Cliente> findById(@PathVariable Long id) {
		return clienteServ.findById(id);
	}

	/**
	 * Salva un nuovo cliente.
	 *
	 * @param cliente Il cliente da salvare.
	 * @return Il cliente salvato.
	 */
	@PostMapping
	public Cliente save(@RequestBody Cliente cliente) {
		return clienteServ.save(cliente);
	}

	/**
	 * Aggiorna un cliente esistente per ID.
	 *
	 * @param id      ID del cliente da aggiornare.
	 * @param cliente Dati del cliente per l'aggiornamento.
	 * @return Il cliente aggiornato (o null se non esiste).
	 */
	@PutMapping("/{id}")
	public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) {
		Cliente c = clienteServ.findById(id).orElse(null);

//		se l'entità con l'id nell'url esiste
		if (c != null) {
//			cambia solo quello che viene passato, tutto il resto lo lasci cosi come si trova
			c.setNome(cliente.getNome() == null ? c.getNome() : cliente.getNome());
			c.setCognome(cliente.getCognome() == null ? c.getCognome() : cliente.getCognome());

			clienteServ.save(c);

			return c;
		}

		return null;
	}

	/**
	 * Elimina un cliente per ID.
	 *
	 * @param id ID del cliente da eliminare.
	 */
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		clienteServ.deleteById(id);
	}
}
