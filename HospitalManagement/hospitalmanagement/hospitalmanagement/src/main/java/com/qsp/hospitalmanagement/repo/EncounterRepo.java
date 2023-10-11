package com.qsp.hospitalmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospitalmanagement.dto.Encounter;

public interface EncounterRepo extends JpaRepository<Encounter, Integer> {

}
