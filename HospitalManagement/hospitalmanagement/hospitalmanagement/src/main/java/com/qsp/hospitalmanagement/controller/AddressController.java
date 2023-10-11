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

import com.qsp.hospitalmanagement.dto.Address;
import com.qsp.hospitalmanagement.service.AddressService;
import com.qsp.hospitalmanagement.util.ResponseStructure;


@RestController
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@PostMapping("/saveaddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@Valid@RequestBody Address address)
	{
		return service.saveAddress(address);
	}
	
	@GetMapping("/getaddress/{id}")
	public ResponseEntity<ResponseStructure<Address>> findAddress(@PathVariable int id)
	{
		return service.findAddress(id);
	}
	
	@PutMapping("/updateaddress/{id}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@PathVariable int id,@Valid@RequestBody Address address)
	{
	return service.updateAddress(id,address);
		 
	}
	
	@DeleteMapping("/deleteaddress/{id}")
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@PathVariable int id)
	{ 
	  return service.deleteAddress(id); 
	}

}
