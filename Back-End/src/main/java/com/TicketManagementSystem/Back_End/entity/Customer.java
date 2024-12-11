package com.TicketManagementSystem.Back_End.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor

@Data
//Making the customer entity
public class Customer {

    @Id
    @Column(name = "customer_id", length = 10)
    private int customerId;

    @Column(name = "customer_retrieval_rate", length = 10, nullable = false)
    private int customerRetrievalRate;

    @Column(name = "quantity", length = 10, nullable = false)
    private int quantity;


}
