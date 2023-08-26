package com.alinazim.ms.ticket.mapper.factory;

import com.alinazim.ms.ticket.dao.entity.TicketEntity;
import com.alinazim.ms.ticket.model.response.TicketResponse;

import static com.alinazim.ms.ticket.model.enums.TicketStatus.PENDING;

public enum TicketMapper {
    TICKET_MAPPER;

    public TicketResponse buildTicketResponse(TicketEntity ticket) {
        return TicketResponse.builder()
                .orderId(ticket.getOrderId())
                .ticketId(ticket.getId())
                .ticketStatus(ticket.getTicketStatus())
                .build();
    }

    public TicketEntity buildTicketEntity(Long orderId) {
        return TicketEntity.builder()
                .orderId(orderId)
                .ticketStatus(PENDING)
                .build();
    }
}
