package com.nray.ticketmanagement.service;

import com.nray.ticketmanagement.dto.TicketDTO;
import com.nray.ticketmanagement.dto.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TicketService {
    TicketDTO createTicket(TicketDTO ticket);
    Optional<TicketDTO> getTicketById(Long id);
    Page<TicketDTO> getAllTickets(Pageable pageable, String user, Status status);
    Optional<TicketDTO> updateTicket(TicketDTO ticket);
    boolean deleteTicket(Long id);
}
