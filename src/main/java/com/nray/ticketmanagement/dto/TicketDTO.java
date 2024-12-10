package com.nray.ticketmanagement.dto;

import java.time.LocalDateTime;

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

    public TicketDTO(Long id, String user, LocalDateTime createdAt, LocalDateTime updatedAt, Status status) {
        this.id = id;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}