package com.TicketManagementSystem.Back_End.Service;

import com.TicketManagementSystem.Back_End.dto.request.CustomerSaveRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    String saveCustomer(CustomerSaveRequestDTO saveRequestDTO);

}
