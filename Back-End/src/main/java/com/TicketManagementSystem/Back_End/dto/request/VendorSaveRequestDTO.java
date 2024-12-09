package com.TicketManagementSystem.Back_End.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class VendorSaveRequestDTO {

    private int vendorId;


    private int ticketPerRelease;

    private int totalTickets;

}

