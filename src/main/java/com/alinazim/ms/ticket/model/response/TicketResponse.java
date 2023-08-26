package com.alinazim.ms.ticket.model.response;

import com.alinazim.ms.ticket.model.enums.TicketStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponse {
    private Long ticketId;
    private Long orderId;
    private TicketStatus ticketStatus;
}
