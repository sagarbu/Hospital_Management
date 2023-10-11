package com.qsp.hospitalmanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.hospitalmanagement.dto.Person;
import com.qsp.hospitalmanagement.service.PersonService;
import com.qsp.hospitalmanagement.util.ResponseStructure;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	
	@PostMapping("/saveperson")
	public ResponseEntity<ResponseStructure<Person>> savePerson(@Valid@RequestBody Person person)
	{
		return service.savePerson(person);
	}
	
	
	@GetMapping("/findperson/{id}")
	public ResponseEntity<ResponseStructure<Person>> findPerson(@PathVariable int id)
	{
		return service.findPerson(id);
	}
	
	
	@PutMapping("/updateperson/{id}")
	public ResponseEntity<ResponseStructure<Person>>  updatePerson(@PathVariable int id,@Valid@RequestBody Person person)
	{
		return service.updatePerson(id, person);
	}
	
	@DeleteMapping("/deleteperson/{id}")
	public ResponseEntity<ResponseStructure<Person>> deletePerson(@PathVariable int id)
	{
		return service.deletePerson(id);
	}

}
