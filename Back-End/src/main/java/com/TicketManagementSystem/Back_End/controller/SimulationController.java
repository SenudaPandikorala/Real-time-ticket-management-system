package com.TicketManagementSystem.Back_End.controller;

import com.TicketManagementSystem.Back_End.Service.SimulationService;
import com.TicketManagementSystem.Back_End.entity.ConfigurationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.module.Configuration;

@RestController
@RequestMapping("api/v1/simulation")

public class SimulationController {

    @Autowired
    private SimulationService simulationService;

    @PostMapping("/start")
    public String startSimulation(@RequestBody ConfigurationData configurationData){
        simulationService.startSimulation(configurationData);
        return "Simulation started";
    }
    @PostMapping("/stop")
    public String stopSimulation(){
        simulationService.stopSimulation();
        return "Simulation stopped.";
    }
}
