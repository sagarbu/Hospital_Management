package com.qsp.hospitalmanagement.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospitalmanagement.dao.EncounterDao;
import com.qsp.hospitalmanagement.dto.Encounter;
import com.qsp.hospitalmanagement.exception.IdNotFound;
import com.qsp.hospitalmanagement.util.ResponseStructure;

@Service
public class EncounterService {
	
	@Autowired
	private EncounterDao dao;
	
	public ResponseEntity<ResponseStructure<Encounter>> saveEncounter(Encounter encounter ,int pid,int  bid)
	{
		ResponseStructure<Encounter> structure=new ResponseStructure<>();
		structure.setMessage("Data saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveEncounter(encounter, pid, bid));
		return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> findEncounter(int id)
	{
		ResponseStructure<Encounter> structure=new ResponseStructure<>();
		Encounter encounter= dao.findEncounter(id);
		if(encounter!=null)
		{
			structure.setMessage("Found  Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.FOUND);
		}
		else
		{
			 throw new IdNotFound("Id Not Found");
		}
		 
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> updateEncounter(int id,Encounter encounter)
	{
		ResponseStructure<Encounter> structure=new ResponseStructure<>();
		Encounter dbencounter= dao.findEncounter(id);
		if(dbencounter!=null)
		{   
			encounter.setId(id);
			structure.setMessage("Data Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateEncounter(id, encounter));	
			return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.OK);
		}
		else
		{
			 throw new IdNotFound("Id Not Found");
		}
		 
	}
	
	public ResponseEntity<ResponseStructure<Encounter>> deleteEncounter(int id)
	{
		ResponseStructure<Encounter> structure=new ResponseStructure<>();
		Encounter encounter= dao.findEncounter(id);
		if(encounter!=null)
		{
			structure.setMessage("Deleted  Successfully");
			structure.setStatus(HttpStatus.OK.value());
			dao.deleteEncounter(id);
			structure.setData(encounter);
			return new ResponseEntity<ResponseStructure<Encounter>>(structure,HttpStatus.OK);
		}
		else
		{
			 throw new IdNotFound("Id Not Found");		
		}
		 
		
	}

}
