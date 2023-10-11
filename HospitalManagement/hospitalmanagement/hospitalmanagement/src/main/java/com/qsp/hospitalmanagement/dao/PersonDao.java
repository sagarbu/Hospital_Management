package com.qsp.hospitalmanagement.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospitalmanagement.dto.Person;
import com.qsp.hospitalmanagement.repo.PersonRepo;

@Repository
public class PersonDao {
	
	@Autowired
	private PersonRepo repo;
	
	public Person savePerson(Person person)
	{
		return repo.save(person);
	}
	
	public Person findPerson(int id)
	{
		Optional<Person> person= repo.findById(id);
		if(person.isPresent())
		{
			return person.get();
		}
		return null;
	}
	
	public Person  updatePerson(int id,Person person)
	{
		Optional<Person> dbperson=repo.findById(id);
		if(dbperson.isPresent())
		{
			person.setId(id);
			return repo.save(person);
		}
		return null;
	}
	
	public Person deletePerson(int id)
	{
		Optional<Person> person=repo.findById(id);
		if(person.isPresent())
		{
			repo.deleteById(id);
			return person.get();
		}
		return null;
	}

}
