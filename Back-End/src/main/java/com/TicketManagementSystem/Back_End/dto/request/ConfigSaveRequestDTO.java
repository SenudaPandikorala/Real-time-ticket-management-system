package com.TicketManagementSystem.Back_End.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConfigSaveRequestDTO {

    private int totalTickets;

    private int ticketReleaseRate;

    private int customerRetrievalRate;

    private int maxTicketCapacity;
}
