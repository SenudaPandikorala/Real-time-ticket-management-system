package com.TicketManagementSystem.Back_End.Service;

import com.TicketManagementSystem.Back_End.dto.request.VendorSaveRequestDTO;

public interface VendorService {

    String saveVendor(VendorSaveRequestDTO vendorSaveRequestDto);
}
