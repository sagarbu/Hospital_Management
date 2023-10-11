package com.qsp.hospitalmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospitalmanagement.dao.HospitalDao;
import com.qsp.hospitalmanagement.dto.Hospital;
import com.qsp.hospitalmanagement.exception.IdNotFound;
import com.qsp.hospitalmanagement.util.ResponseStructure;

@Service
public class HospitalService {
	
	@Autowired
	private HospitalDao dao;
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital)
	{
		ResponseStructure<Hospital> structure= new ResponseStructure<>();
		structure.setMessage("Data saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveHospital(hospital));
		return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.CREATED);	
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> findHospital(int id)
	{
		ResponseStructure<Hospital> structure= new ResponseStructure<>();
		Hospital hospital= dao.findHospital(id);
		if(hospital!=null)
		{
			structure.setMessage("Found successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.FOUND);
			
		}
		else
		{
			throw new IdNotFound("Id Not Found");
		}
		 
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id,Hospital hospital)
	{
		ResponseStructure<Hospital> structure= new ResponseStructure<>();
		Hospital dbhospital= dao.findHospital(id);
		if(dbhospital!=null)
		{
			hospital.setId(id);
			structure.setMessage("Data updated successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.saveHospital(hospital));
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
		}
		else
		{
			 throw new IdNotFound("Id Not Found");
		}
		 
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id)
	{
		ResponseStructure<Hospital> structure= new ResponseStructure<>();
		Hospital hospital= dao.findHospital(id);
		if(hospital!=null)
		{
			structure.setMessage("Deleted Successfully");
			structure.setStatus(HttpStatus.OK.value());
			dao.deleteHospital(id);
			structure.setData(hospital);
			return new ResponseEntity<ResponseStructure<Hospital>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new IdNotFound("ID Not FOund");
		}
		 
	}
	
	

}
