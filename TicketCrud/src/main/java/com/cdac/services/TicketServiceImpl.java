package com.cdac.services;

import com.cdac.dto.TicketDTO;
import com.cdac.entity.Ticket;
import com.cdac.entity.enums.Status;
import com.cdac.repositories.TicketRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketDTO createTicket(TicketDTO ticketDTO) {
        Ticket entityTicket = new Ticket();
        BeanUtils.copyProperties(ticketDTO,entityTicket);
        entityTicket.setCreatedDateTime(LocalDateTime.now());
        ticketRepository.save(entityTicket);
        BeanUtils.copyProperties(entityTicket,ticketDTO);
        return ticketDTO;
    }

    @Override
    public TicketDTO updateTicket(TicketDTO ticketDTO) {
        Optional<Ticket> entityTicket = ticketRepository.findById(ticketDTO.getId());
        if(entityTicket.isEmpty()){
            throw new RuntimeException("Ticket with id -> "+ticketDTO.getId() +" not found");
        }
        if(ticketDTO.getStatus() != null){
            entityTicket.get().setStatus(ticketDTO.getStatus());
        }
        if(ticketDTO.getResolutionDetails() != null){
            entityTicket.get().setResolutionDetails(ticketDTO.getResolutionDetails());
        }
        if(ticketDTO.getResolutionDateTime() != null){
            entityTicket.get().setResolutionDateTime(ticketDTO.getResolutionDateTime());
        }
        ticketRepository.save(entityTicket.get());
        BeanUtils.copyProperties(entityTicket,ticketDTO);
        return ticketDTO;
    }

    @Override
    public List<TicketDTO> fetchAllOpenTickets() {
        List<Ticket> ticketsList = ticketRepository.findByStatus(Status.OPEN);
        List<TicketDTO> ticketDTOList = new ArrayList<>();
        if(ticketsList.isEmpty()){
            throw new RuntimeException("No data is present add data in list");
        }
        for(Ticket entityTicket : ticketsList){
            TicketDTO dto = new TicketDTO();
            BeanUtils.copyProperties(entityTicket,dto);
            ticketDTOList.add(dto);
        }

        return ticketDTOList;
    }

    @Override
    public TicketDTO fetchTicketById(long id) {
        Optional<Ticket> entityTicket = ticketRepository.findById(id);
        if(entityTicket.isEmpty()){
            throw new RuntimeException("Ticket with id -> "+id +" not found");
        }

        TicketDTO dto = new TicketDTO();
        BeanUtils.copyProperties(entityTicket.get(),dto);
        return dto;

    }
}
