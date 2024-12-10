package com.TicketManagementSystem.Back_End.Service.impl;

import com.TicketManagementSystem.Back_End.Service.ConfigurationService;
import com.TicketManagementSystem.Back_End.dto.request.ConfigSaveRequestDTO;
import com.TicketManagementSystem.Back_End.entity.ConfigurationData;
import com.TicketManagementSystem.Back_End.repo.ConfigurationRepo;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class ConfigurationServiceImpl implements ConfigurationService {
    private static final Logger logger = LoggerFactory.getLogger(ConfigurationServiceImpl.class);
    @Autowired
    private ConfigurationRepo configurationRepo;
    @Getter
    private int totalTickets;

    @Getter
    private int ticketReleaseRate;

    @Getter
    private int customerRetrievalRate;

    @Getter
    private int maxTicketCapacity;



    @Override
    public void saveconfig(ConfigSaveRequestDTO saveRequestDTO){

        ConfigurationData configurationData = new ConfigurationData(
                saveRequestDTO.getTotalTickets(),
                saveRequestDTO.getCustomerRetrievalRate(),
                saveRequestDTO.getTicketReleaseRate(),
                saveRequestDTO.getMaxTicketCapacity()
        );
        configurationRepo.save(configurationData);
        this.totalTickets= saveRequestDTO.getTotalTickets();
        this.customerRetrievalRate= saveRequestDTO.getCustomerRetrievalRate();
        this.maxTicketCapacity = saveRequestDTO.getMaxTicketCapacity();
        this.ticketReleaseRate = saveRequestDTO.getTicketReleaseRate();
        logger.info("Configuration data saved");

    }

//    @Override
//    public ConfigurationData getConfiguration() {
//        return null;
//    }
}
