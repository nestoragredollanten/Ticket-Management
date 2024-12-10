package com.nray.ticketmanagement.repository;

import com.nray.ticketmanagement.entity.TicketEntity;
import com.nray.ticketmanagement.dto.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
    Page<TicketEntity> findByUser(String user, Pageable pageable);
    Page<TicketEntity> findByStatus(Status status, Pageable pageable);
    Page<TicketEntity> findByUserAndStatus(String user, Status status, Pageable pageable);
}
