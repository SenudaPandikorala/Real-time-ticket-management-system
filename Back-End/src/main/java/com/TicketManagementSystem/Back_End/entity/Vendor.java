package com.TicketManagementSystem.Back_End.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "vendor")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Vendor {
    @Id
    @Column(name = "vendor_id", length = 10)
    private int vendorId;

    @Column(name = "tickets_per_release", length = 10, nullable = false)
    private int ticketPerRelease;

    @Column(name = "total_tickets", length = 10, nullable = false)
    private int totalTickets;


}
