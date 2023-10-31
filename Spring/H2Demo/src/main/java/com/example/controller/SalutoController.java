package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Saluto;
import com.example.service.SalutoService;

@RestController
public class SalutoController {

	@Autowired
	private SalutoService salutoServ;
	
	@GetMapping("/saluto")
	public Saluto saluto(@RequestParam String messaggio) {
		return salutoServ.saveSaluto(messaggio);
	}
}
