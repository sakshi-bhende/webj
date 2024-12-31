package com.cdac.services;

import com.cdac.dto.TicketDTO;

import java.util.List;

public interface TicketService {
    TicketDTO createTicket(TicketDTO ticketDTO);
    TicketDTO updateTicket(TicketDTO ticketDTO);
    List<TicketDTO> fetchAllOpenTickets();
    TicketDTO fetchTicketById(long id);

}
