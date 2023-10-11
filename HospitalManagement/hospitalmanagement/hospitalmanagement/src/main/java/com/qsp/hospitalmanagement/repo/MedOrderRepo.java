package com.qsp.hospitalmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospitalmanagement.dto.MedOrder;

public interface MedOrderRepo extends JpaRepository<MedOrder, Integer>{

}
