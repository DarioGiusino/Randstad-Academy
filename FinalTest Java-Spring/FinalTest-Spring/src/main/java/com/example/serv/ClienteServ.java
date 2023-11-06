package com.example.serv;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Cliente;
import com.example.repo.ClienteRepo;

@Service
public class ClienteServ {

	@Autowired
	private ClienteRepo clienteRepo;

	/**
	 * Recupera tutti i clienti presenti.
	 *
	 * @return Una lista di clienti.
	 */
	public List<Cliente> findAll() {
		return clienteRepo.findAll();
	}

	/**
	 * Salva un cliente.
	 *
	 * @param cliente Il cliente da salvare.
	 * @return Il cliente salvato.
	 */
	public Cliente save(Cliente cliente) {
		return clienteRepo.save(cliente);
	}

	/**
	 * Trova un cliente tramite ID.
	 *
	 * @param id L'ID del cliente da trovare.
	 * @return Un'istanza Optional che può o meno contenere il cliente trovato.
	 */
	public Optional<Cliente> findById(Long id) {
		return clienteRepo.findById(id);
	}

	/**
	 * Cancella un cliente tramite ID.
	 *
	 * @param id L'ID del cliente da cancellare.
	 */
	public void deleteById(Long id) {
		clienteRepo.deleteById(id);
	}
}
