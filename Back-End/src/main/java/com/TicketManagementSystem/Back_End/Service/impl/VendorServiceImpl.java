package com.TicketManagementSystem.Back_End.Service.impl;

import com.TicketManagementSystem.Back_End.Service.VendorService;
import com.TicketManagementSystem.Back_End.dto.request.VendorSaveRequestDTO;
import com.TicketManagementSystem.Back_End.entity.Vendor;
import com.TicketManagementSystem.Back_End.repo.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepo vendorRepo;
    //method to save a vendor to the database
    @Override
    public String saveVendor(VendorSaveRequestDTO vendorSaveRequestDto) {
        Vendor vendor= new Vendor(
                vendorSaveRequestDto.getVendorId(),
                vendorSaveRequestDto.getTicketPerRelease(),
                vendorSaveRequestDto.getTotalTickets()

        );
        vendorRepo.save(vendor);

        return "Saved";
    }
}
