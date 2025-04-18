package com.TicketManagementSystem.Back_End.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "configuration_data")
@NoArgsConstructor
@AllArgsConstructor

@Data
public class ConfigurationData { //Making the entity of configurations  class


    @Id
    @Column(name = "total_tickets", length = 10)
    private int totalTickets;

    @Column(name = "ticket_release_rate", length = 10, nullable = false)
    private int ticketReleaseRate;

    @Column(name = "customer_retrieval_rate", length = 10, nullable = false)
    private int customerRetrievalRate;


    @Column(name = "max_ticket_capacity", length = 10, nullable = false)
    @Getter
    private int maxTicketCapacity;






}
