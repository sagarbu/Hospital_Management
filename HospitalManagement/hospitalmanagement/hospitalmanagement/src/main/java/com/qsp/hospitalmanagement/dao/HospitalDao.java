package com.qsp.hospitalmanagement.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospitalmanagement.dto.Hospital;
import com.qsp.hospitalmanagement.repo.HospitalRepo;

@Repository
public class HospitalDao {
	
	@Autowired
	private HospitalRepo repo;
	
	
	public Hospital saveHospital(Hospital hospital)
	{
		return repo.save(hospital);
	}
	
	
	public Hospital findHospital(int id)
	{
		Optional<Hospital> hospital=repo.findById(id);
		if(hospital.isPresent())
		{
			return hospital.get();
		}
		return null;
	}
	
	public Hospital updateHospital(int id,Hospital hospital)
	{
		Optional<Hospital> dbhospital=repo.findById(id);
		if(dbhospital.isPresent())
		{   
			hospital.setId(id);
			return repo.save(hospital);
		}
		return null;
	}
	
	public Hospital deleteHospital(int id)
	{
		Optional<Hospital> hospital=repo.findById(id);
		if(hospital.isPresent())
		{
			repo.deleteById(id);
			return hospital.get();
		}
		return null;
	}

}
