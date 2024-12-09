package com.TicketManagementSystem.Back_End.controller;


import com.TicketManagementSystem.Back_End.Service.ConfigurationService;
import com.TicketManagementSystem.Back_End.dto.request.ConfigSaveRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/configuration")
public class ConfigurationController {

    @Autowired
    ConfigurationService configurationService;
    @PostMapping(path ="/saveConfig")
    public String saveConfig(@RequestBody ConfigSaveRequestDTO saveRequestDTO){
        String inputs = configurationService.saveconfig(saveRequestDTO);

        return inputs;
    }

}
