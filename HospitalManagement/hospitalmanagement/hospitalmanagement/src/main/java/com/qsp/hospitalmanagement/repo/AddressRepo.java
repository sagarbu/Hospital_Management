package com.qsp.hospitalmanagement.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.qsp.hospitalmanagement.dto.Address;
public interface AddressRepo extends  JpaRepository<Address, Integer>{

}
