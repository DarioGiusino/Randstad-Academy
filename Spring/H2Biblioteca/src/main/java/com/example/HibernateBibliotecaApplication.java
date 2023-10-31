package com.example;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.Libro;
import com.example.entity.Membro;
import com.example.serv.LibroServ;
import com.example.serv.MembroServ;

@SpringBootApplication
public class HibernateBibliotecaApplication implements CommandLineRunner{
	
	@Autowired
	private LibroServ libroServ;
	@Autowired
	private MembroServ membroServ;

	public static void main(String[] args) {
		SpringApplication.run(HibernateBibliotecaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Membro m1 = new Membro(1l, "nom1", "cognome1", "email1", new HashSet<>());
		
		membroServ.addMembro(m1);
		
		Libro l1 = new Libro(1l, "titolo1", "genere1");
		Libro l2 = new Libro(2l, "titolo2", "genere2");
		Libro l3 = new Libro(3l, "titolo3", "genere3");
		
		libroServ.addLibro(l1);
		libroServ.addLibro(l2);
		libroServ.addLibro(l3);
	}

}
