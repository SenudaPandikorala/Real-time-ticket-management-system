package com.TicketManagementSystem.Back_End.Service.impl;

import com.TicketManagementSystem.Back_End.Service.VendorService;
import com.TicketManagementSystem.Back_End.dto.request.VendorSaveRequestDto;
import com.TicketManagementSystem.Back_End.entity.Vendor;
import com.TicketManagementSystem.Back_End.repo.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepo vendorRepo;

    @Override
    public String saveVendor(VendorSaveRequestDto vendorSaveRequestDto) {
        Vendor vendor= new Vendor(
                vendorSaveRequestDto.getVendorId(),
                vendorSaveRequestDto.getTicketPerRelease(),
                vendorSaveRequestDto.getTotalTickets()

        );
        vendorRepo.save(vendor);

        return "Saved";
    }
}
