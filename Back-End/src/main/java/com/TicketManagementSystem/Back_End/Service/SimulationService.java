package com.TicketManagementSystem.Back_End.Service;

import com.TicketManagementSystem.Back_End.entity.ConfigurationData;

public interface SimulationService {
    void startSimulation();

    void stopSimulation() throws InterruptedException;
}
