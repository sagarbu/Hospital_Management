package com.qsp.hospitalmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service; 
import com.qsp.hospitalmanagement.dao.BranchDao;
import com.qsp.hospitalmanagement.dto.Branch;
import com.qsp.hospitalmanagement.exception.IdNotFound;
import com.qsp.hospitalmanagement.util.ResponseStructure;

@Service
public class BranchService {
	
	@Autowired
	private BranchDao dao;
	
	 
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch,int aid,int hid)
	{   
	     
		ResponseStructure<Branch> structure=new ResponseStructure<>();
		structure.setMessage("Save Sucessfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveBranch(branch, hid, aid));
		return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.CREATED);	
	}
	
	public ResponseEntity<ResponseStructure<Branch>> findBranchById(int id)
	{   
		ResponseStructure<Branch> structure=new ResponseStructure<>();
		Branch branch=dao.findBranch(id);
		if(branch!=null)
		{
			structure.setMessage("Found Sucessfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.FOUND);	
		}
		else
		{ 
			throw new IdNotFound("Id Not Found");
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id,Branch branch)
	{
		
		ResponseStructure<Branch> structure=new ResponseStructure<>();
		Branch dbbranch=dao.findBranch(id);
		if(dbbranch!=null)
		{
		branch.setId(id);
		structure.setMessage("Updated Sucessfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setData(dao.updateBranch(id, branch));
		return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new IdNotFound("Id Not Found");
		}
	  
	}
	
	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id)
	{
		ResponseStructure<Branch> structure=new ResponseStructure<>();
		Branch branch=dao.findBranch(id);
		if(branch!=null)
		{
			structure.setMessage("Deleted  Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			dao.deleteBranch(id);
			structure.setData(branch);
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.FOUND);
		}
		else
		{
			throw new IdNotFound("Id Not Found");
		}
		 
	}

}
