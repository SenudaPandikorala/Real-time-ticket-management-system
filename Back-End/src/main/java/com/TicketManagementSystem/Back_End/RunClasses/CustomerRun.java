package com.TicketManagementSystem.Back_End.RunClasses;

import com.TicketManagementSystem.Back_End.Service.TicketPoolService;
import com.TicketManagementSystem.Back_End.entity.Ticket;

public class CustomerRun implements Runnable {

        private TicketPoolService ticketPoolService;
        private int customerId;
        private int customerRetrievalRate;
        private int quantity;
        private final boolean running;

        public CustomerRun(int customerId,TicketPoolService ticketPoolService, int customerRetrievalRate, int quantity,boolean running) {

            this.ticketPoolService = ticketPoolService;
            this.customerId = customerId;
            this.customerRetrievalRate = customerRetrievalRate;// ticket removing frequency from the ticket pool.
            this.quantity=quantity;
            this.running =running;// number of tickets customer willing to purchase.

        }


        @Override
        public void run(){
            for (int i =0; i<quantity; i++){

                if(!running){
//                    LoggerUtil.logInfo("Customer "+ customerId + " stopped");
                    System.out.println("Customer "+ customerId + " stopped");
                    break;
                }
                Ticket ticket = ticketPoolService.buyTicket();

                //details of the ticket
                if (ticket !=null) {
//                    LoggerUtil.logInfo(" Tickets bought by : " + Thread.currentThread().getName() + "Ticket is = " + ticket);
                    System.out.println(" Tickets bought by : " + Thread.currentThread().getName() + "Ticket is = " + ticket);
                }else{
//                    LoggerUtil.logWarning("Customer " + customerId + " customer could not purchase a ticket because the ticket pool is empty");
                    System.out.println("Customer " + customerId + " customer could not purchase a ticket because the ticket pool is empty");
                }

                //ticket removing delay
                try{
                    Thread.sleep(customerRetrievalRate * 1000);

                }catch (InterruptedException e){
//                    LoggerUtil.logWarning("Customer " + customerId+ " interrupted" + e.getMessage());
                    System.out.println("Customer " + customerId+ " interrupted" + e.getMessage());
                    Thread.currentThread().interrupt();
                    break;
                }
            }
//            LoggerUtil.logInfo("Customer " + customerId + " has finished purchasing tickets. ");
            System.out.println("Customer " + customerId + " has finished purchasing tickets. ");
        }




}
