package com.TicketManagementSystem.Back_End.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
//Making a DTO class to transfer data from a service
public class ConfigSaveRequestDTO {

    private int totalTickets;

    private int ticketReleaseRate;

    private int customerRetrievalRate;

    private int maxTicketCapacity;
}
