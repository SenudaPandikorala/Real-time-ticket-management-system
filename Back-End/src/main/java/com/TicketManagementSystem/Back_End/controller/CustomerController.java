package com.TicketManagementSystem.Back_End.controller;


import com.TicketManagementSystem.Back_End.Service.CustomerService;
import com.TicketManagementSystem.Back_End.dto.request.CustomerSaveRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")

public class CustomerController {

    @Autowired
    private CustomerService customerService;
    //Contoller to save customer in the database
    @PostMapping(path = "/save-customer")
    public String saveCustomer(@RequestBody CustomerSaveRequestDTO saveRequestDTO){

        String message= customerService.saveCustomer(saveRequestDTO);


        return message;
    }




}
