package com.TicketManagementSystem.Back_End.controller;


import com.TicketManagementSystem.Back_End.Service.ConfigurationService;
import com.TicketManagementSystem.Back_End.Service.impl.ConfigurationServiceImpl;
import com.TicketManagementSystem.Back_End.dto.request.ConfigSaveRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@CrossOrigin
@RequestMapping("api/v1/configuration")

//Below are  the Configuration controller to handle the config inputs and to load logs from the database
public class ConfigurationController {
    private static final Logger logger = LoggerFactory.getLogger(ConfigurationServiceImpl.class);
    //Controller to save the configuration inputs into the database
    @Autowired
    ConfigurationService configurationService;
    @PostMapping(path ="/saveConfig")
    public void saveConfig(@RequestBody ConfigSaveRequestDTO saveRequestDTO){
        logger.info("saving the configurations");
        configurationService.saveconfig(saveRequestDTO);

    }


}
