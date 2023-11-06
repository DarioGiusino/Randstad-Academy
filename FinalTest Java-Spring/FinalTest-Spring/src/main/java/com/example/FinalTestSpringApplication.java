package com.example;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.Cliente;
import com.example.entity.Ordine;
import com.example.entity.Prodotto;
import com.example.serv.ClienteServ;
import com.example.serv.OrdineServ;
import com.example.serv.ProdottoServ;

/**
 * La classe FinalTestSpringApplication implementa l'interfaccia CommandLineRunner in un'applicazione Spring Boot.
 * Inizializza e salva dati di esempio per clienti, prodotti e ordini utilizzando i rispettivi servizi.
 */
@SpringBootApplication
public class FinalTestSpringApplication implements CommandLineRunner {
	@Autowired
	private ClienteServ clienteServ;
	
	@Autowired
	private OrdineServ ordineServ;
	
	@Autowired
	private ProdottoServ servizioServ;
	

    /**
     * Il metodo main avvia l'applicazione Spring Boot.
     *
     * @param args Gli argomenti passati da riga di comando.
     */
	public static void main(String[] args) {
		SpringApplication.run(FinalTestSpringApplication.class, args);
	}

    /**
     * Il metodo run viene eseguito dopo che il contesto dell'applicazione Spring Boot è stato caricato.
     * Crea istanze di esempio di Cliente, Prodotto e Ordine e le salva utilizzando i rispettivi servizi.
     *
     * @param args Possibili argomenti da riga di comando.
     * @throws Exception Può essere lanciata un'eccezione.
     */
	@Override
	public void run(String... args) throws Exception {
		Cliente c1 = new Cliente(1l, "nome1", "cognome1");
		Cliente c2 = new Cliente(2l, "nome2", "cognome2");
		Cliente c3 = new Cliente(3l, "nome3", "cognome3");
		
		clienteServ.save(c1);
		clienteServ.save(c2);
		clienteServ.save(c3);
		
		Prodotto s1 = new Prodotto(1l, "cacciavite", 5.99d, 4);
		Prodotto s2 = new Prodotto(2l, "utensile", 3.99d, 9);
		Prodotto s3 = new Prodotto(3l, "utensile3", 8.99d, 1);
		
		servizioServ.save(s1);
		servizioServ.save(s2);
		servizioServ.save(s3);
		
		Ordine o1 = new Ordine(1l, c1, new ArrayList<>());
		Ordine o2 = new Ordine(2l, c2, new ArrayList<>());
		Ordine o3 = new Ordine(3l, c3, new ArrayList<>());
		
		ordineServ.save(o1);
		ordineServ.save(o2);
		ordineServ.save(o3);
		
	}

}
