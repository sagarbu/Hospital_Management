package com.qsp.hospitalmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospitalmanagement.dao.PersonDao;
import com.qsp.hospitalmanagement.dto.Person;
import com.qsp.hospitalmanagement.exception.IdNotFound;
import com.qsp.hospitalmanagement.util.ResponseStructure;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao dao;
	
	public ResponseEntity<ResponseStructure<Person>> savePerson(Person person)
	{
		ResponseStructure<Person> structure=new ResponseStructure<>();
		structure.setMessage("Data save successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.savePerson(person));
		return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.CREATED);	
	}
	
	public ResponseEntity<ResponseStructure<Person>> findPerson(int id)
	{
		ResponseStructure<Person> structure=new ResponseStructure<>();
	    Person person=dao.findPerson(id);
	   if(person!=null)
	   {
		    structure.setMessage("Found successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(person);
			return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.FOUND);	
	   }
	   else
	   {
		    throw new IdNotFound("ID Not Found ");
	   }
	    
	}
	
	public ResponseEntity<ResponseStructure<Person>>  updatePerson(int id,Person person)
	{
		ResponseStructure<Person> structure=new ResponseStructure<>();
		   Person dbperson=dao.findPerson(id);
		   if(person!=null)
		   {
				structure.setMessage("Data Updated successfully");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dao.savePerson(person));
				return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.OK);	
				 	
		   }
		   else
		   {
			   throw new IdNotFound("ID Not Found ");
			   
		   }
		   
	}
	
	public ResponseEntity<ResponseStructure<Person>> deletePerson(int id)
	{
		ResponseStructure<Person> structure=new ResponseStructure<>();
	    Person person=dao.findPerson(id);
	   if(person!=null)
	   {
		    structure.setMessage("Deleted  successfully");
			structure.setStatus(HttpStatus.OK.value());
			dao.deletePerson(id);
			structure.setData(person);	
			return new ResponseEntity<ResponseStructure<Person>>(structure,HttpStatus.OK);	
	   }
	   else
	   {
		   throw new IdNotFound("ID Not Found ");
	   }
	  
		
	}

}
