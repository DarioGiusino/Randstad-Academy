package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Saluto;
import com.example.repo.SalutoRepo;

@Service
public class SalutoService {

	@Autowired
	private SalutoRepo salutoRepo;
	
	public Saluto saveSaluto(String messaggio) {
		Saluto saluto = new Saluto();
		saluto.setMessaggio(messaggio);
		return salutoRepo.save(saluto);
	}
}
