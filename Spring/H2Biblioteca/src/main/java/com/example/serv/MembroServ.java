package com.example.serv;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Membro;
import com.example.repo.MembroRepo;

@Service
public class MembroServ {

	@Autowired
	private MembroRepo membroRepo;

	public Membro addMembro(Membro membro) {
		return membroRepo.save(membro);
	}

	public Collection<Membro> getAllMembro() {
		return membroRepo.findAll();
	}

	public Optional<Membro> getMembroById(Long id) {
		return membroRepo.findById(id);
	}

	public void deleteMembro(Long id) {
		membroRepo.deleteById(id);
	}
}
