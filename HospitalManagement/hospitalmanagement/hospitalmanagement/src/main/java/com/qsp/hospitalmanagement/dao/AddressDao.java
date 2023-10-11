package com.qsp.hospitalmanagement.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospitalmanagement.dto.Address;
import com.qsp.hospitalmanagement.repo.AddressRepo;

@Repository
public class AddressDao {
	
	@Autowired	
	private AddressRepo repo;
	
	
	public Address saveAddress(Address address)
	{
		return repo.save(address);
	}
	
	public Address findById(int id)
	{
		Optional<Address> address= repo.findById(id);
		if(address.isPresent())
		{
			return address.get();
		}
		return null;
	}
	
	
	public Address updateAddress(int id,Address address)
	{   
		Optional<Address> dbaddress= repo.findById(id);
		
		if(dbaddress.isPresent())
		{
			address.setId(id);
			return repo.save(address);
			  
		}
		return null;
	}
	
	public Address deleteAddress(int id)
	{
		Optional<Address> address= repo.findById(id);
		if(address.isPresent())
		{   
			 repo.deleteById(id); 
			return address.get();
		}
		return null;
	}

}
