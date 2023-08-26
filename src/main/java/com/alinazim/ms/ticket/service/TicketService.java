package com.alinazim.ms.ticket.service;

import com.alinazim.ms.ticket.dao.entity.TicketEntity;
import com.alinazim.ms.ticket.dao.repository.TicketRepository;
import com.alinazim.ms.ticket.model.enums.TicketStatus;
import com.alinazim.ms.ticket.model.response.TicketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.alinazim.ms.ticket.mapper.factory.TicketMapper.TICKET_MAPPER;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;


    public void createTicket(Long orderId) {
        ticketRepository.save(
                TICKET_MAPPER.buildTicketEntity(orderId)
        );
    }


    public List<TicketResponse> getTickets() {
        return ticketRepository.findAll()
                .stream()
                .map(TICKET_MAPPER::buildTicketResponse)
                .collect(toList());
    }

    public TicketResponse getTicket(Long ticketId) {
        return TICKET_MAPPER.buildTicketResponse(
                fetTicketById(ticketId)
        );
    }

    public TicketResponse getTicketByStatus(TicketStatus ticketStatus) {
        return TICKET_MAPPER.buildTicketResponse(ticketRepository.findByTicketStatus(ticketStatus));
    }

    public void updateTicket(Long ticketId, TicketStatus ticketStatus) {
        var ticketEntity = fetTicketById(ticketId);
        ticketEntity.setTicketStatus(ticketStatus);
        ticketRepository.save(ticketEntity);
    }

    private TicketEntity fetTicketById(Long ticketId) {
        return ticketRepository.findById(ticketId).orElseThrow(() -> new RuntimeException("Ticket is not found"));
    }
}