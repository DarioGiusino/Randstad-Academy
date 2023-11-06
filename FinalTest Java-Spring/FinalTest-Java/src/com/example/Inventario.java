package com.example;

import java.util.ArrayList;
import java.util.List;

import com.example.entities.Giocattolo;

/**
 * La classe Inventario gestisce l'elenco dei giocattoli disponibili nel
 * negozio.
 */
public class Inventario {
	private List<Giocattolo> listaGiocattoli;

	/**
	 * Costruttore che inizializza l'inventario generando alcuni giocattoli
	 * predefiniti.
	 */
	public Inventario() {
		this.listaGiocattoli = generateGiocattoli();
	}

	/**
	 * Restituisce l'elenco dei giocattoli disponibili nell'inventario.
	 *
	 * @return Una lista di oggetti Giocattolo.
	 */
	public List<Giocattolo> getListaGiocattoli() {
		return listaGiocattoli;
	}

	/**
	 * Imposta la lista dei giocattoli dell'inventario.
	 *
	 * @param listaGiocattoli La lista di giocattoli da impostare.
	 */
	public void setListaGiocattoli(List<Giocattolo> listaGiocattoli) {
		this.listaGiocattoli = listaGiocattoli;
	}

	/**
	 * Restituisce una rappresentazione testuale dell'inventario.
	 *
	 * @return Una stringa che rappresenta l'inventario e i suoi giocattoli.
	 */
	@Override
	public String toString() {
		String s = "";
		for (Giocattolo g : getListaGiocattoli()) {
			s += g.toString();
		}
		return s;
	}

	/**
	 * Genera una lista predefinita di giocattoli per inizializzare l'inventario.
	 *
	 * @return Una lista di giocattoli predefiniti.
	 */
	private List<Giocattolo> generateGiocattoli() {
		List<Giocattolo> lista = new ArrayList<>();

		Giocattolo g1 = new Giocattolo(1L, "giocattolo1", 7.22, 12);
		Giocattolo g2 = new Giocattolo(2L, "giocattolo2", 4.22, 5);
		Giocattolo g3 = new Giocattolo(3L, "giocattolo3", 1.22, 16);

		lista.add(g1);
		lista.add(g2);
		lista.add(g3);

		return lista;
	}
}
