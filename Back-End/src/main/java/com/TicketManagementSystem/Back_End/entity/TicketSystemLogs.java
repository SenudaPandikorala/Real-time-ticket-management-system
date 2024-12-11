package com.TicketManagementSystem.Back_End.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tickets_log")
@NoArgsConstructor
@AllArgsConstructor

//Making the ticket system logs entity.
public class TicketSystemLogs {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "log", length = 2000, nullable = false)
    private String message;

}
