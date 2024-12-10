package com.TicketManagementSystem.Back_End.Service.impl;

import com.TicketManagementSystem.Back_End.Service.TicketPoolService;
import com.TicketManagementSystem.Back_End.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Service
public class TicketPoolServiceImpl implements TicketPoolService {
    private static final Logger logger = LoggerFactory.getLogger(ConfigurationServiceImpl.class);

    private final Queue<Ticket> ticketQueue = new LinkedList<>();

    private int maxCapacity;


    @Override
    public synchronized void addTicket(Ticket ticket) {
        try {
            while (ticketQueue.size() >= maxCapacity) {
                if (!Thread.currentThread().isInterrupted()) {
                    wait();
                } else {
                    logger.info("Thread interrupted while adding ticket. Exiting");
                    return;
                }
            }
            ticketQueue.add(ticket);
            logger.info(Thread.currentThread().getName() + " added ticket. Current size: " + ticketQueue.size());
            notifyAll();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.info("Thread interrupted while adding ticket.Exiting");
        }
    }




    @Override
    public synchronized Ticket buyTicket() {
        try {
            while (ticketQueue.isEmpty()) {
                if (!Thread.currentThread().isInterrupted()) {
                    wait(); // Wait if the queue is empty
                } else {
                    // Exit gracefully if interrupted
                    logger.info("Thread interrupted while buying ticket. Exiting...");
                    return null;
                }
            }
            Ticket ticket = ticketQueue.poll();
            logger.info(Thread.currentThread().getName() + " purchased ticket. Current size: " + ticketQueue.size());
            notifyAll(); // Notify other threads waiting
            return ticket;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Re-set the interrupted flag
            logger.info("Thread interrupted while buying ticket. Exiting...");
            return null;
        }
    }


    @Override
    public void setMaxCapacity(int maxTicketCapacity){
        this.maxCapacity=maxTicketCapacity;
    }
}
