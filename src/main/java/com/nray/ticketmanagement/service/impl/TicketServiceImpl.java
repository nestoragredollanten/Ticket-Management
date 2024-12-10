package com.nray.ticketmanagement.service.impl;

import com.nray.ticketmanagement.dto.Status;
import com.nray.ticketmanagement.dto.TicketDTO;
import com.nray.ticketmanagement.entity.TicketEntity;
import com.nray.ticketmanagement.repository.TicketRepository;
import com.nray.ticketmanagement.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final ModelMapper mapper;

    public TicketServiceImpl(TicketRepository ticketRepository, ModelMapper mapper) {
        this.ticketRepository = ticketRepository;
        this.mapper = mapper;
    }

    @Override
    public TicketDTO createTicket(TicketDTO ticket) {
        return mapper.map(ticketRepository.save(mapper.map(ticket, TicketEntity.class)), TicketDTO.class);
    }

    @Override
    public Optional<TicketDTO> getTicketById(Long id) {
        return ticketRepository.findById(id).map(
                ticket -> mapper.map(ticket, TicketDTO.class));
    }

    @Override
    public Page<TicketDTO> getAllTickets(Pageable pageable, String user, Status status) {
        Page<TicketEntity> tickets;
        if (user != null && status != null) {
            tickets = ticketRepository.findByUserAndStatus(user, status, pageable);
        } else if (user != null) {
            tickets = ticketRepository.findByUser(user, pageable);
        } else if (status != null) {
            tickets = ticketRepository.findByStatus(status, pageable);
        } else {
            tickets = ticketRepository.findAll(pageable);
        }

        // Mapeamos la página de Ticket a TicketDTO
        return mapPageToDTO(tickets);
    }

    @Override
    public Optional<TicketDTO> updateTicket(TicketDTO ticket) {
        if (ticketRepository.existsById(ticket.getId())) {
            return Optional.of(mapper.map(ticketRepository.save(mapper.map(ticket, TicketEntity.class)), TicketDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteTicket(Long id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Page<TicketDTO> mapPageToDTO(Page<TicketEntity> ticketEntities) {
        List<TicketDTO> ticketDTOs = ticketEntities.getContent().stream()
                .map(ticket -> mapper.map(ticket, TicketDTO.class))
                .toList();

        return new PageImpl<>(ticketDTOs, ticketEntities.getPageable(), ticketEntities.getTotalElements());
    }
}