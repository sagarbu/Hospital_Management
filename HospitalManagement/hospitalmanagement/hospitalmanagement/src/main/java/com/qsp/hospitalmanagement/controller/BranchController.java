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

import com.qsp.hospitalmanagement.dto.Branch;
import com.qsp.hospitalmanagement.service.BranchService;
import com.qsp.hospitalmanagement.util.ResponseStructure;

@RestController
public class BranchController {
	
	@Autowired
	private BranchService service;
	
	
	@PostMapping("/savebranch/{hid}/{aid}")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@Valid@RequestBody Branch branch,@PathVariable int hid,@PathVariable int aid)
	{
		return service.saveBranch(branch, hid, aid);
	}
	
	@GetMapping("/findbranch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> findBranchById(@PathVariable int id)
	{
		return service.findBranchById(id);
	}
	
	@PutMapping("/updatebranch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@PathVariable int id,@Valid@RequestBody Branch branch)
	{
		return service.updateBranch(id, branch);
	}
	
	@DeleteMapping("/deletebranch/{id}")
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(@PathVariable int id)
	{
		return service.deleteBranch(id);
	}

}
