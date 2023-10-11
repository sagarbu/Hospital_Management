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

import com.qsp.hospitalmanagement.dto.MedOrder;
import com.qsp.hospitalmanagement.service.MedOrderService;
import com.qsp.hospitalmanagement.util.ResponseStructure;

@RestController
public class MedOrderController {
	
	@Autowired
	private MedOrderService service;
	
	@PostMapping("/saveorder/{eid}")
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(@Valid@RequestBody MedOrder order,@PathVariable int eid)
	{
		return service.saveMedOrder(order, eid);
	}
	
	@GetMapping("/getorder/{id}")
	public ResponseEntity<ResponseStructure<MedOrder>> findMedOrder(@PathVariable int id)
	{
		return service.findMedOrder(id);
	}
	
	@PutMapping("/updateorder/{id}")
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@PathVariable int id,@Valid@RequestBody MedOrder order)
	{
		return service.updateMedOrder(id, order);
	}
	
	@DeleteMapping("/deleteorder/{id}")
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(@PathVariable int id)
	{
		return service.deleteMedOrder(id);
	}
		

}
