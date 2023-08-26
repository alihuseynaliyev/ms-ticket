package com.alinazim.ms.ticket.controller;

import com.alinazim.ms.ticket.model.enums.TicketStatus;
import com.alinazim.ms.ticket.model.response.TicketResponse;
import com.alinazim.ms.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("internal/v1/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @PostMapping("/{orderId}")
    public void createTicket(@PathVariable Long orderId) {
        ticketService.createTicket(orderId);
    }

    @GetMapping
    public List<TicketResponse> getTickets() {
        return ticketService.getTickets();
    }

    @GetMapping("/{ticketId}")
    public TicketResponse getTicket(@PathVariable Long ticketId) {
        return ticketService.getTicket(ticketId);
    }

    @GetMapping("/status")
    public TicketResponse getTicketByStatus(TicketStatus ticketStatus) {
        return ticketService.getTicketByStatus(ticketStatus);
    }

    @PutMapping("/{ticketId}/status/{status}")
    public void updateTicket(@PathVariable Long ticketId, @PathVariable TicketStatus status) {
        ticketService.updateTicket(ticketId, status);
    }
}
