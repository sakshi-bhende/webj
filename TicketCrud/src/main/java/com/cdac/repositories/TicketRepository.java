package com.cdac.repositories;

import com.cdac.dto.TicketDTO;
import com.cdac.entity.Ticket;
import com.cdac.entity.enums.Category;
import com.cdac.entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    List<Ticket> findByStatus(Status status);
}
