package com.TicketManagementSystem.Back_End.Service.impl;

import com.TicketManagementSystem.Back_End.RunClasses.CustomerRun;
import com.TicketManagementSystem.Back_End.RunClasses.VendorRun;
import com.TicketManagementSystem.Back_End.Service.SimulationService;
import com.TicketManagementSystem.Back_End.Service.TicketPoolService;
import com.TicketManagementSystem.Back_End.entity.ConfigurationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimulationServiceImpl implements SimulationService {
    private volatile  boolean running = false;
    private List<Thread> vendorThreads = new ArrayList<>();
    private List<Thread> customerThreads = new ArrayList<>();
    @Autowired
    private TicketPoolService ticketPoolService;

    // Creating the method to start the simulation
    @Override
    public synchronized void startSimulation(ConfigurationData configurationData) {
        if(running){
            throw new IllegalStateException("simulation is running already.");
        }
        running =true;
        ticketPoolService.setMaxCapacity(configurationData.getMaxTicketCapacity());

        //Creating and starting vendor threads
        for (int i = 0; i < 10; i++) {
            VendorRun vendorRun = new VendorRun(i, ticketPoolService, configurationData.getTicketReleaseRate(), configurationData.getTotalTickets(),running);
            Thread vendorThread = new Thread(vendorRun, "Vendor-" + i);
            vendorThreads.add(vendorThread);
            vendorThread.start();
        }

        //Creating and starting vendor threads

        for (int i = 0; i < 10; i++) {
            CustomerRun customerRun = new CustomerRun(i, ticketPoolService, configurationData.getCustomerRetrievalRate(), 10,running);
            Thread customerThread = new Thread(customerRun, "Customer-" + i);
            customerThreads.add(customerThread);
            customerThread.start();
        }

    }

    //Creating a method to stop the simulation.
    @Override
    public synchronized void stopSimulation() {
        if (!running) {
            throw new IllegalStateException("Simulation is not running.");
        }

        running = false;

        try {
            // Wait for all threads to complete
            for (Thread vendorThread : vendorThreads) {
                vendorThread.join();
            }
            for (Thread customerThread : customerThreads) {
                customerThread.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            vendorThreads.clear();
            customerThreads.clear();
            running = false;
        }
    }
}
