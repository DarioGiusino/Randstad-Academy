package com.example.serv;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Ordine;
import com.example.repo.OrdineRepo;

@Service
public class OrdineServ {

	@Autowired
	private OrdineRepo ordineRepo;

	/**
	 * Recupera tutti gli ordini presenti.
	 *
	 * @return Una lista di ordini.
	 */
	public List<Ordine> findAll() {
		return ordineRepo.findAll();
	}

	/**
	 * Salva un ordine.
	 *
	 * @param ordine L'ordine da salvare.
	 * @return L'ordine salvato.
	 */
	public Ordine save(Ordine ordine) {
		return ordineRepo.save(ordine);
	}

	/**
	 * Trova un ordine tramite ID.
	 *
	 * @param id L'ID dell'ordine da trovare.
	 * @return Un'istanza Optional che può o meno contenere l'ordine trovato.
	 */
	public Optional<Ordine> findById(Long id) {
		return ordineRepo.findById(id);
	}

	/**
	 * Cancella un ordine tramite ID.
	 *
	 * @param id L'ID dell'ordine da cancellare.
	 */
	public void deleteById(Long id) {
		ordineRepo.deleteById(id);
	}
}
