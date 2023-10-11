package com.qsp.hospitalmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.hospitalmanagement.dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
