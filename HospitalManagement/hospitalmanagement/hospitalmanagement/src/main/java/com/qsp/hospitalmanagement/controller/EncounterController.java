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

 
import com.qsp.hospitalmanagement.dto.Encounter;
import com.qsp.hospitalmanagement.service.EncounterService;
import com.qsp.hospitalmanagement.util.ResponseStructure;

@RestController
public class EncounterController {
	
	@Autowired
	private EncounterService service;
	
	@PostMapping("/saveencounter/{pid}/{bid}")
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(@Valid@RequestBody Encounter encounter , @PathVariable int pid,@PathVariable int bid)
	{
		return service.saveEncounter(encounter, pid, bid);
	}
	
	@GetMapping("/findencounter/{id}")
	public ResponseEntity<ResponseStructure<Encounter>> findEncounter(@PathVariable int id)
	{
		return service.findEncounter(id);
	}	
	
	@PutMapping("/updateencounter/{id}")
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(@PathVariable int id,@Valid@RequestBody Encounter encounter)
	{
		return service.updateEncounter(id, encounter);
	}
	
	@DeleteMapping("/deleteencounter/{id}")
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(@PathVariable int id)
	{
	   return service.deleteEncounter(id);	
	}

}
