package com.TicketManagementSystem.Back_End.controller;

import com.TicketManagementSystem.Back_End.Service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/simulation")

public class SimulationController {
    private static final Logger logger = LoggerFactory.getLogger(SimulationController.class);

    @Autowired
    private SimulationService simulationService;

    @PostMapping("/start")
    public String startSimulation(){
        logger.info("Starting the simulation");
        simulationService.startSimulation();
        return "Simulation started";
    }
    @PostMapping("/stop")
    public String stopSimulation() throws InterruptedException {
        logger.info("stopping the simulation");
        simulationService.stopSimulation();
        return "Simulation stopped.";
    }
}
