package com.qsp.hospitalmanagement.dao;

 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospitalmanagement.dto.Address;
import com.qsp.hospitalmanagement.dto.Branch;
import com.qsp.hospitalmanagement.dto.Hospital;
import com.qsp.hospitalmanagement.repo.BranchRepo;

 

@Repository
public class BranchDao {
	
	@Autowired
	private BranchRepo repo;
	
	@Autowired
	private HospitalDao dao;
	
	@Autowired
	private AddressDao addressdao;
	
	public Branch saveBranch(Branch branch,int hid,int aid)
	{
		Hospital hospital = dao.findHospital(hid);
		branch.setHospital(hospital);
		Address address = addressdao.findById(aid);
		branch.setAddress(address);
		return repo.save(branch);
	 
	}
	
	public Branch findBranch(int id)
	{
		Optional<Branch> optional=repo.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	public Branch updateBranch(int id,Branch branch)
	{
		Branch dbbranch=repo.findById(id).get();
		if(dbbranch!=null)
		{   
			branch.setId(id);
			branch.setHospital(dbbranch.getHospital());
			branch.setAddress(dbbranch.getAddress());
			 
			return repo.save(branch);
		}
		return null;
	}
	
	
	public Branch deleteBranch(int id)
	{
		Optional<Branch> optional=repo.findById(id);
		if(optional.isPresent())
		{ 
			
			repo.deleteById(id);
			return optional.get();
		}
		return null;
	}
	
	 
}
