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
import com.qsp.hospitalmanagement.dto.Hospital;
import com.qsp.hospitalmanagement.service.HospitalService;
import com.qsp.hospitalmanagement.util.ResponseStructure;

@RestController
public class HospitalController {
	
	@Autowired
	private HospitalService service;
	
	@PostMapping("/savehospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@Valid@RequestBody Hospital hospital)
	{
		return service.saveHospital(hospital);
	}
	
	@GetMapping("/findhospital/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> findHospital(@PathVariable int id)
	{
		return service.findHospital(id);
	}
	
	@PutMapping("/updatehospital/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@PathVariable int id,@Valid@RequestBody Hospital hospital)
	{
		return service.updateHospital(id, hospital);
	}
	
	@DeleteMapping("/deletehospital/{id}")
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(@PathVariable int id)
	{
		return service.deleteHospital(id);
	}
	

}

