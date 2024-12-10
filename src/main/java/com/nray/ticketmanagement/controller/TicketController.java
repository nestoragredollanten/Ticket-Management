package com.nray.ticketmanagement.controller;

import com.nray.ticketmanagement.dto.Status;
import com.nray.ticketmanagement.dto.TicketDTO;
import com.nray.ticketmanagement.service.TicketService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketRequest ticketRequest) {
        TicketDTO dto = new TicketDTO(ticketRequest.user(), LocalDateTime.now(), LocalDateTime.now(), ticketRequest.status);

        return ResponseEntity.ok(ticketService.createTicket(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<TicketDTO>> getAllTickets(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String user,
            @RequestParam(required = false) Status status
    ) {
        Page<TicketDTO> tickets = ticketService.getAllTickets(PageRequest.of(page, size), user, status);
        return ResponseEntity.ok(tickets);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDTO> updateTicket(
            @PathVariable Long id,
            @RequestBody TicketRequest ticketRequest
    ) {
        TicketDTO updatedTicket = new TicketDTO(id, ticketRequest.user(), LocalDateTime.now(), ticketRequest.status);

        return ticketService.updateTicket(updatedTicket)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        if (ticketService.deleteTicket(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public record TicketRequest(String user, Status status) {}
}