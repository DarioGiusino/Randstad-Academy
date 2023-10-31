package com.example.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ticket;
import com.example.demo.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository ticketRepo;
	
	public Ticket addTicket(Ticket ticket) {
		return ticketRepo.addTicket(ticket);
	}

	public Collection<Ticket> getAllTickets() {
		return ticketRepo.getAllTickets();
	}

	public Ticket getTicketById(Long id) {
		return ticketRepo.getTicketById(id);
	}

	public Ticket updateTicket(Long id, Ticket ticket) {
		return ticketRepo.updateTicket(id, ticket);
	}

	public void deleteTicket(Long id) {
		ticketRepo.deleteTicket(id);
	}
}
