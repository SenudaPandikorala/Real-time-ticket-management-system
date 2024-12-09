package com.TicketManagementSystem.Back_End.Service.impl;

import com.TicketManagementSystem.Back_End.Service.ConfigurationService;
import com.TicketManagementSystem.Back_End.dto.request.ConfigSaveRequestDTO;
import com.TicketManagementSystem.Back_End.entity.ConfigurationData;
import com.TicketManagementSystem.Back_End.repo.ConfigurationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {
    @Autowired
    private ConfigurationRepo configurationRepo;

    @Override
    public String saveconfig(ConfigSaveRequestDTO saveRequestDTO){

        ConfigurationData configurationData = new ConfigurationData(
                saveRequestDTO.getTotalTickets(),
                saveRequestDTO.getCustomerRetrievalRate(),
                saveRequestDTO.getTicketReleaseRate(),
                saveRequestDTO.getMaxTicketCapacity()
        );
        configurationRepo.save(configurationData);
        return "Configuration saved";



    }

//    @Override
//    public ConfigurationData getConfiguration() {
//        return null;
//    }
}
