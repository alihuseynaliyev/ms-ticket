package com.alinazim.ms.ticket.dao.repository;

import com.alinazim.ms.ticket.dao.entity.TicketEntity;
import com.alinazim.ms.ticket.model.enums.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    TicketEntity findByTicketStatus(TicketStatus ticketStatus);
}
