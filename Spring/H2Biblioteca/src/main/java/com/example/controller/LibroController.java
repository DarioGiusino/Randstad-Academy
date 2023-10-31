package com.example.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Libro;
import com.example.serv.LibroServ;

@RestController
@RequestMapping("/libro")
public class LibroController {
	
	@Autowired
	private LibroServ libroService;
	
	@GetMapping
	public Collection<Libro> LibroList(){
		return libroService.getAllLibro();
	}
	
	@GetMapping("/{id}")
	public Optional<Libro> getLibroByID(@PathVariable Long id) {
		return libroService.getLibroById(id);
	}
	
	@PostMapping
	public Libro addNewLibro(@RequestBody Libro libro) {		
		return libroService.addLibro(libro);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLibro(@PathVariable Long id) {
		libroService.deleteLibro(id);
	}
}



