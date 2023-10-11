package com.qsp.hospitalmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospitalmanagement.dto.Hospital;

public interface HospitalRepo  extends JpaRepository<Hospital, Integer>{

}
