package com.TicketManagementSystem.Back_End.Service;

import com.TicketManagementSystem.Back_End.dto.request.ConfigSaveRequestDTO;

public interface ConfigurationService {

    String saveconfig(ConfigSaveRequestDTO saveRequestDTO);

}
