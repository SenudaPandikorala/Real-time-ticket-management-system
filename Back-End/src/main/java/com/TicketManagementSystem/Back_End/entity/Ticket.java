package com.TicketManagementSystem.Back_End.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "ticket")
@NoArgsConstructor
@AllArgsConstructor
@Data

//Making the ticket entity
public class Ticket {
    @Id
    @Column(name = "ticket_id", length = 10)
    private int ticketId;

    @Column(name = "event_name", length = 100, nullable = false)
    private String eventName;

    @Column(name = "ticket_price", length = 100, nullable = false)
    private BigDecimal ticketPrice;
}
