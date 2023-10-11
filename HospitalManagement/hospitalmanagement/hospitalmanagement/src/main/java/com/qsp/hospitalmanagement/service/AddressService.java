package com.qsp.hospitalmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospitalmanagement.dao.AddressDao;
import com.qsp.hospitalmanagement.dto.Address;
import com.qsp.hospitalmanagement.exception.IdNotFound;
import com.qsp.hospitalmanagement.util.ResponseStructure;

@Service
public class AddressService {
	
	@Autowired
	private AddressDao dao;
	
	
	
	
	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address)
	{
		ResponseStructure<Address> structure=new ResponseStructure<>();
	    structure.setMessage("Data save successfully");
	    structure.setStatus(HttpStatus.CREATED.value());
	    structure.setData(dao.saveAddress(address));
	    return new  ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.CREATED);	
	}
	
	public ResponseEntity<ResponseStructure<Address>> findAddress(int id)
	{
		ResponseStructure<Address> structure=new ResponseStructure<>();
		Address address=dao.findById(id);
		if(address!=null)
		{
			structure.setMessage("Found successfully");
		    structure.setStatus(HttpStatus.FOUND.value());
		    structure.setData(address);
		    return new  ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.FOUND); 
		}
		else
		{		 
         throw new IdNotFound("ID Not Found");
		}
		 
	}
	
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id,Address address)
	{
		  ResponseStructure<Address> structure=new ResponseStructure<>();
	      Address dbaddress=dao.findById(id);
	      if(dbaddress!=null)
	      {
	    	  address.setId(id);
	    	  structure.setMessage("Data Updated successfully");
	  	      structure.setStatus(HttpStatus.CREATED.value());
	  	      structure.setData(dao.saveAddress(address));
	  	      return new  ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.CREATED);
	      }
	      else
	      {
	    	  throw new IdNotFound("ID Not Found");
			}
	     
	      
	     
	}
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id)
	{
		ResponseStructure<Address> structure=new ResponseStructure<>();
		Address address=dao.findById(id);
		if(address!=null)
		{
			structure.setMessage("Data delete successfully");
	  	    structure.setStatus(HttpStatus.OK.value());
            dao.deleteAddress(id);
	  	    structure.setData(address);
	  	    return new  ResponseEntity<ResponseStructure<Address>>(structure,HttpStatus.OK);
			 
		}
		else
		{
			 throw new IdNotFound("ID Not Found");
			 
		}
		
	}

}
