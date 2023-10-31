package com.example.serv;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Libro;
import com.example.repo.LibroRepo;

@Service
public class LibroServ {

	@Autowired
	private LibroRepo libroRepo;

	public Libro addLibro(Libro libro) {
		return libroRepo.save(libro);
	}

	public Collection<Libro> getAllLibro() {
		return libroRepo.findAll();
	}

	public Optional<Libro> getLibroById(Long id) {
		return libroRepo.findById(id);
	}

	public void deleteLibro(Long id) {
		libroRepo.deleteById(id);;
	}
    
}
