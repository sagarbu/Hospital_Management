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

import com.qsp.hospitalmanagement.dto.MedItems;
import com.qsp.hospitalmanagement.service.MedItemsService;
import com.qsp.hospitalmanagement.util.ResponseStructure;

@RestController
public class MedItemsController {
	
	@Autowired
	private MedItemsService service;
	
	@PostMapping("/saveitems/{mod}")
	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(@Valid@RequestBody MedItems items,@PathVariable int mod)
	{
		return service.saveMedItems(items, mod);
	}
	
	@GetMapping("/finditems/{id}")
	public ResponseEntity<ResponseStructure<MedItems>> findMedItems(@PathVariable int id)
	{
		return service.findMedItems(id);
	}
	
	@PutMapping("/updateitems/{id}")
	 public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(@Valid@PathVariable int id,@RequestBody MedItems items)
	 {
		 return service.updateMedItems(id, items);
	 }
	
	@DeleteMapping("/deleteitems/{id}") 
	public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems(@PathVariable int id)
	 {
		 return service.deleteMedItems(id);
	 }

}
