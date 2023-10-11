package com.qsp.hospitalmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospitalmanagement.dao.MedItemsDao;
import com.qsp.hospitalmanagement.dto.MedItems;
import com.qsp.hospitalmanagement.exception.IdNotFound;
import com.qsp.hospitalmanagement.util.ResponseStructure;

@Service
public class MedItemsService {
	
	@Autowired
	private MedItemsDao dao;
	
	public ResponseEntity<ResponseStructure<MedItems>> saveMedItems(MedItems items,int mid)
	{
		ResponseStructure<MedItems> structure=new ResponseStructure<>();
		structure.setMessage("Data saved Sucessfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveMedItems(items, mid));
		return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<MedItems>> findMedItems(int id)
	{
		ResponseStructure<MedItems> structure=new ResponseStructure<>();
		MedItems items= dao.findMedItems(id);
		if(items!=null)
		{
			structure.setMessage("Found Sucessfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(items);
			return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.FOUND);
		}
		else
		{
			throw new IdNotFound("ID Not Found");
		}
		 
	}
	
	 public ResponseEntity<ResponseStructure<MedItems>> updateMedItems(int id,MedItems items)
	 {
		 ResponseStructure<MedItems> structure=new ResponseStructure<>();
		 MedItems dbitems= dao.findMedItems(id);
		 if(dbitems!=null)
		 {
			    structure.setMessage("Data Updated Sucessfully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dao.updateMedItems(id, items)); 
				return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.OK);
		 }
		 else
		 {
			   throw new IdNotFound("Id nOt Found");
		 }
		 
		 
	 }
	 
	 public ResponseEntity<ResponseStructure<MedItems>> deleteMedItems(int id)
	 {
		 ResponseStructure<MedItems> structure=new ResponseStructure<>();
		 MedItems items= dao.findMedItems(id);
		 if(items!=null)
		 {
			  structure.setMessage("Deleted Sucessfully");
			  structure.setStatus(HttpStatus.OK.value());
			  dao.deleteMedItems(id);
			  structure.setData(items); 
			  return new ResponseEntity<ResponseStructure<MedItems>>(structure,HttpStatus.OK);
		 }
		 else
		 {
			 throw new IdNotFound("Id Not Found");
		 }
		  
		 
	 }
	
	

}
