package com.example.controller;

import java.util.Collection;
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

import com.example.entity.Membro;
import com.example.serv.MembroServ;

@RestController
@RequestMapping("/membro")
public class MembroController {
	
	@Autowired
	private MembroServ membroService;
	
	@GetMapping
	public Collection<Membro> MembroList(){
		return membroService.getAllMembro();
	}
	
	@GetMapping("/{id}")
	public Optional<Membro> getMembroByID(@PathVariable Long id) {
		return membroService.getMembroById(id);
	}
	
	@PostMapping
	public Membro addNewMembro(@RequestBody Membro membro) {		
		return membroService.addMembro(membro);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMembro(@PathVariable Long id) {
		membroService.deleteMembro(id);
	}
	
	@PutMapping("/{id}")
	public Membro updateMembro(@PathVariable Long id, @RequestBody Membro membro) {
		
		if(membroService.getMembroById(id) != null) {
			return membroService.addMembro(membro);
		}
		
		return null;
	}
}



