package com.TicketManagementSystem.Back_End.controller;

import com.TicketManagementSystem.Back_End.Service.VendorService;
import com.TicketManagementSystem.Back_End.dto.request.VendorSaveRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("api/v1/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @PostMapping(path = "/save-vendor")
    public String saveVendor(@RequestBody VendorSaveRequestDTO vendorSaveRequestDto){

        String message= vendorService.saveVendor(vendorSaveRequestDto);


        return message;
    }
}
