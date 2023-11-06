package com.example.serv;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Prodotto;
import com.example.repo.ProdottoRepo;

@Service
public class ProdottoServ {

	@Autowired
	private ProdottoRepo prodottoRepo;

	/**
	 * Recupera tutti i prodotti presenti.
	 *
	 * @return Una lista di prodotti.
	 */
	public List<Prodotto> findAll() {
		return prodottoRepo.findAll();
	}

	/**
	 * Salva un prodotto.
	 *
	 * @param servizio Il prodotto da salvare.
	 * @return Il prodotto salvato.
	 */
	public Prodotto save(Prodotto servizio) {
		return prodottoRepo.save(servizio);
	}

	/**
	 * Trova un prodotto tramite ID.
	 *
	 * @param id L'ID del prodotto da trovare.
	 * @return Un'istanza Optional che può o meno contenere il prodotto trovato.
	 */
	public Optional<Prodotto> findById(Long id) {
		return prodottoRepo.findById(id);
	}

	/**
	 * Cancella un prodotto tramite ID.
	 *
	 * @param id L'ID del prodotto da cancellare.
	 */
	public void deleteById(Long id) {
		prodottoRepo.deleteById(id);
	}
}
