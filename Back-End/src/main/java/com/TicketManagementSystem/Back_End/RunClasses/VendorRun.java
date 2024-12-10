package com.TicketManagementSystem.Back_End.RunClasses;

import com.TicketManagementSystem.Back_End.Service.TicketPoolService;
import com.TicketManagementSystem.Back_End.entity.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class VendorRun implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(VendorRun.class);

        private TicketPoolService ticketPoolService; //ticket pool which is shared by the customer and vendors.
        private int vendorId;
        private int ticketPerRelease;
        private int totalTickets;
        private final boolean running;//number of tickets vendor willing to sell.

        public VendorRun(int vendorId, TicketPoolService ticketPoolService, int ticketPerRelease, int totalTickets,boolean running) {

            this.vendorId = vendorId;
            this.ticketPoolService=ticketPoolService;
            this.ticketPerRelease = ticketPerRelease;
            this.totalTickets = totalTickets;
            this.running = running;
        }

        @Override
        public void run() {
            System.out.println(totalTickets);

            for (int i = 1; i <= totalTickets; i++) {

                if (!running) {
                    logger.info("Vendor " + vendorId + " stopped");

                    break;
                }
                //creating and adding a ticket to the pool
                Ticket ticket = new Ticket(i, "event agastra", new BigDecimal("1000"));

                ticketPoolService.addTicket(ticket);

                logger.info("Vendor " + vendorId + " added ticket:" + ticket);


                try {
                    Thread.sleep(ticketPerRelease * 1000);
                } catch (InterruptedException e) {

                    logger.info("Vendor " + vendorId + " interrupted:" + e.getMessage());
                    Thread.currentThread().interrupt();
                    break;
                }
            }

            logger.info("vendor " + vendorId + " finished releasing tickets");


        }


    }


