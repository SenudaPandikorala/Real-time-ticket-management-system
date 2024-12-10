package com.TicketManagementSystem.Back_End.Service;

import com.TicketManagementSystem.Back_End.entity.Ticket;

public interface TicketPoolService {
    void addTicket(Ticket ticket);
    Ticket buyTicket();

    void setMaxCapacity(int maxTicketCapacity);

}
