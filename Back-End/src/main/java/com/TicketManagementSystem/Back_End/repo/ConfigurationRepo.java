package com.TicketManagementSystem.Back_End.repo;


import com.TicketManagementSystem.Back_End.entity.ConfigurationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Configuration repository layer

@Repository
public interface ConfigurationRepo extends JpaRepository<ConfigurationData,Integer> {
}
