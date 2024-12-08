package com.TicketManagementSystem.Back_End.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerSaveRequestDTO {

    private int customerId;

    private int customerRetrievalRate;

    private int quantity;
}