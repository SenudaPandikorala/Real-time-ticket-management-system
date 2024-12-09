package com.TicketManagementSystem.Back_End.Service.impl;


import com.TicketManagementSystem.Back_End.Service.TicketPoolService;
import com.TicketManagementSystem.Back_End.entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class TicketPoolServiceImpl implements TicketPoolService {

    private final Queue<Ticket> ticketQueue = new LinkedList<>();
    private final int maxCapacity = 100; // hardcoded maxcapacity


    @Override
    public synchronized void addTicket(Ticket ticket) {
        while (ticketQueue.size() >= maxCapacity) {
            try {
                wait(); //waiting if the que
            } catch (InterruptedException e){
                throw new RuntimeException("Thread interrupted while adding ticket:" + e.getMessage());
            }
        }
        ticketQueue.add(ticket);
        notifyAll();

    }

    @Override
    public synchronized Ticket buyTicket() {
        while (ticketQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread interrupted while purchasing of tickets:" + e.getMessage());
            }
        }
        Ticket ticket = ticketQueue.poll();
        notifyAll();
        return ticket;

    }
}
