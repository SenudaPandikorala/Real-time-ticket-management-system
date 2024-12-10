package com.TicketManagementSystem.Back_End.RunClasses;

import com.TicketManagementSystem.Back_End.Service.TicketPoolService;
import com.TicketManagementSystem.Back_End.Service.impl.ConfigurationServiceImpl;
import com.TicketManagementSystem.Back_End.entity.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerRun implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(CustomerRun.class);


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

                    logger.info("Customer "+ customerId + " stopped");
                    break;
                }
                Ticket ticket = ticketPoolService.buyTicket();

                //details of the ticket
                if (ticket !=null) {

                    logger.info(" Tickets bought by : " + Thread.currentThread().getName() + "Ticket is = " + ticket);
                }else{

                   logger.info("Customer " + customerId + " customer could not purchase a ticket because the ticket pool is empty");
                }

                //ticket removing delay
                try{
                    Thread.sleep(customerRetrievalRate * 1000);

                }catch (InterruptedException e){

                    logger.info("Customer " + customerId+ " interrupted" + e.getMessage());
                    Thread.currentThread().interrupt();
                    break;
                }
            }

            logger.info("Customer " + customerId + " has finished purchasing tickets. ");
        }




}
