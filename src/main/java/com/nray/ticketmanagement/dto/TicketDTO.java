package com.nray.ticketmanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class TicketDTO {
    private Long id;
    private String user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Status status;

    public TicketDTO() {
    }

    public TicketDTO(String user, LocalDateTime createdAt, LocalDateTime updatedAt, Status status) {
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public TicketDTO(Long id, String user, LocalDateTime updatedAt, Status status) {
        this.id = id;
        this.user = user;
        this.updatedAt = updatedAt;
        this.status = status;
    }

}