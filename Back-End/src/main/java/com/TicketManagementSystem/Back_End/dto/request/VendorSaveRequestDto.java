package com.TicketManagementSystem.Back_End.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class VendorSaveRequestDto {

    private int vendorId;


    private int ticketPerRelease;

    private int totalTickets;

}

