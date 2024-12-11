package com.TicketManagementSystem.Back_End.repo;

import com.TicketManagementSystem.Back_End.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories

//Vendor  repository layer
public interface VendorRepo extends JpaRepository<Vendor,Integer> {
}
