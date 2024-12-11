package com.TicketManagementSystem.Back_End.Service;



public interface SimulationService {
    void startSimulation();

    void stopSimulation() throws InterruptedException;
}
