package com.TicketManagementSystem.Back_End.RunClasses;

import com.TicketManagementSystem.Back_End.Service.TicketPoolService;
import com.TicketManagementSystem.Back_End.entity.Ticket;

import java.math.BigDecimal;

public class VendorRun implements Runnable {

        private TicketPoolService ticketPoolService; //ticket pool which is shared by the customer and vendors.
        private int vendorId;
        private int ticketPerRelease;
        private int totalTickets;
        private final boolean running;//number of tickets vendor willing to sell.

        public VendorRun(int vendorId, TicketPoolService ticketPoolService, int ticketPerRelease, int totalTickets,boolean running) {
//        super(ticketPool);
            this.vendorId = vendorId;
            this.ticketPoolService=ticketPoolService;
            this.ticketPerRelease = ticketPerRelease;
            this.totalTickets = totalTickets;
            this.running = running;
        }

        @Override
        public void run() {

            for (int i = 1; i <= totalTickets; i++) {

                if (!running) {
//                    LoggerUtil.logInfo("Vendor " + vendorId + " stopped");
                    System.out.println("Vendor " + vendorId + " stopped");

                    break;
                }
                //creating and adding a ticket to the pool
                Ticket ticket = new Ticket(i, "event agastra", new BigDecimal("1000"));
                ticketPoolService.addTicket(ticket);
//                LoggerUtil.logInfo("Vendor " + vendorId + " added ticket:" + ticket);
                System.out.println("Vendor " + vendorId + " added ticket:" + ticket);


                try {
                    Thread.sleep(ticketPerRelease * 1000);
                } catch (InterruptedException e) {
//                    LoggerUtil.logWarning("Vendor " + vendorId + " interrupted:" + e.getMessage());
                    System.out.println("Vendor " + vendorId + " interrupted:" + e.getMessage());
                    Thread.currentThread().interrupt();
                    break;
                }
            }
//            LoggerUtil.logInfo("vendor " + vendorId + " finished releasing tickets");
            System.out.println("vendor " + vendorId + " finished releasing tickets");


        }


    }


