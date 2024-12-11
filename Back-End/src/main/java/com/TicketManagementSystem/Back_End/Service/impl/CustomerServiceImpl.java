package com.TicketManagementSystem.Back_End.Service.impl;

import com.TicketManagementSystem.Back_End.Service.CustomerService;
import com.TicketManagementSystem.Back_End.dto.request.CustomerSaveRequestDTO;
import com.TicketManagementSystem.Back_End.entity.Customer;
import com.TicketManagementSystem.Back_End.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    //Method to save the customer data to the database
    @Override
    public String saveCustomer(CustomerSaveRequestDTO saveRequestDTO) {

        Customer customer= new Customer(
                saveRequestDTO.getCustomerId(),
                saveRequestDTO.getCustomerRetrievalRate(),
                saveRequestDTO.getQuantity()

        );
        customerRepo.save(customer);

        return "Saved";

    }

    
}
