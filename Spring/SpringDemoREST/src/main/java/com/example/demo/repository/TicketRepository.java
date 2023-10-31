package com.example.demo.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ticket;

@Repository
public class TicketRepository {
	
	private final Map<Long, Ticket> ticketListMap = new HashMap<>();
	private Long currentId = 1L;
	
	public Ticket addTicket(Ticket ticket) {
		ticket.setId(currentId++);
		ticketListMap.put(ticket.getId(), ticket);
		return ticket;
	}

	public Collection<Ticket> getAllTickets() {
		return ticketListMap.values();
	}

	public Ticket getTicketById(Long id) {
		return ticketListMap.get(id);
	}

	public Ticket updateTicket(Long id, Ticket ticket) {
		if (ticketListMap.containsKey(id)) {
			ticket.setId(id);
			ticketListMap.put(id, ticket);
			return ticket;
		}
		return null;
	}

	public void deleteTicket(Long id) {
		ticketListMap.remove(id);
	}

}
