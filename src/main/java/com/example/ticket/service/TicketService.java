
package com.example.ticket.service;

import com.example.ticket.dto.TicketDTO;
import com.example.ticket.entity.Ticket;
import com.example.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public TicketDTO createTicket(TicketDTO ticketDTO) {
        Ticket ticket = mapToEntity(ticketDTO);
        ticket.setCreateDateTime(LocalDateTime.now());
        return mapToDTO(ticketRepository.save(ticket));
    }

    public TicketDTO updateTicket(Long id, TicketDTO ticketDTO) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        if (ticketDTO.getStatus() != null) {
            ticket.setStatus(Ticket.Status.valueOf(ticketDTO.getStatus()));
        }
        if (ticketDTO.getResolutionDetails() != null) {
            ticket.setResolutionDetails(ticketDTO.getResolutionDetails());
        }
        if (ticketDTO.getResolutionDateTime() != null) {
            ticket.setResolutionDateTime(ticketDTO.getResolutionDateTime());
        }

        return mapToDTO(ticketRepository.save(ticket));
    }

    public TicketDTO getTicketById(Long id) {
        return ticketRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public List<TicketDTO> getAllOpenTickets() {
        return ticketRepository.findAll().stream()
                .filter(ticket -> ticket.getStatus() == Ticket.Status.OPEN)
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private Ticket mapToEntity(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketDTO.getId());
        ticket.setRequesterPhoneNumber(ticketDTO.getRequesterPhoneNumber());
        ticket.setCategory(Ticket.Category.valueOf(ticketDTO.getCategory()));
        ticket.setIssueDetails(ticketDTO.getIssueDetails());
        ticket.setResolutionDetails(ticketDTO.getResolutionDetails());
        ticket.setStatus(Ticket.Status.valueOf(ticketDTO.getStatus()));
        ticket.setCreateDateTime(ticketDTO.getCreateDateTime());
        ticket.setResolutionDateTime(ticketDTO.getResolutionDateTime());
        return ticket;
    }

    private TicketDTO mapToDTO(Ticket ticket) {
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setId(ticket.getId());
        ticketDTO.setRequesterPhoneNumber(ticket.getRequesterPhoneNumber());
        ticketDTO.setCategory(ticket.getCategory().name());
        ticketDTO.setIssueDetails(ticket.getIssueDetails());
        ticketDTO.setResolutionDetails(ticket.getResolutionDetails());
        ticketDTO.setStatus(ticket.getStatus().name());
        ticketDTO.setCreateDateTime(ticket.getCreateDateTime());
        ticketDTO.setResolutionDateTime(ticket.getResolutionDateTime());
        return ticketDTO;
    }
}
