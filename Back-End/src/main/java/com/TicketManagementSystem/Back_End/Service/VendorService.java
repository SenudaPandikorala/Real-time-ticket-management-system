package com.TicketManagementSystem.Back_End.Service;

import com.TicketManagementSystem.Back_End.dto.request.CustomerSaveRequestDTO;
import com.TicketManagementSystem.Back_End.dto.request.VendorSaveRequestDto;

public interface VendorService {

    String saveVendor(VendorSaveRequestDto vendorSaveRequestDto);
}
