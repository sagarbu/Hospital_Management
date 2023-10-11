package com.qsp.hospitalmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospitalmanagement.dto.MedItems;

public interface MedItemsRepo extends JpaRepository<MedItems, Integer>{

}
