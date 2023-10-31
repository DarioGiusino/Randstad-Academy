package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Ticket;
import com.example.demo.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping
	public Collection<Ticket> TicketList(){
		return ticketService.getAllTickets();
	}
	
	@GetMapping("/{id}")
	public Ticket getTicketByID(@PathVariable Long id) {
		return ticketService.getTicketById(id);
	}
	
	@PostMapping
	public ResponseEntity<Ticket> addNewTicket(@RequestBody Ticket ticket) {
	    if (ticket.getPrice() < 0) {
	        return ResponseEntity.noContent().build();
	    }
	    
	    Ticket savedTicket = ticketService.addTicket(ticket);
	    return ResponseEntity.ok(savedTicket);
	}
	
	@PutMapping("/{id}")
	public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
		return ticketService.updateTicket(id, ticket);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTicket(@PathVariable Long id) {
		ticketService.deleteTicket(id);
	}
}



