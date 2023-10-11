package com.qsp.hospitalmanagement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospitalmanagement.dto.Branch;
import com.qsp.hospitalmanagement.dto.Encounter;
import com.qsp.hospitalmanagement.repo.EncounterRepo;

@Repository
public class EncounterDao {
	
	@Autowired
	private EncounterRepo repo;
	
	@Autowired
	private PersonDao persondao;
	
	@Autowired
	private BranchDao branchdao;
	
	public Encounter saveEncounter(Encounter encounter ,int pid,int bid)
	{    
	 
		encounter.setPerson(persondao.findPerson(pid));
		Branch branch = branchdao.findBranch(bid);
		List<Branch> branchs = new ArrayList<>();
		branchs.add(branch);
		encounter.setBranchs(branchs);
	    return repo.save(encounter);
	}
	
	public Encounter findEncounter(int id)
	{
		Optional<Encounter> encounter=repo.findById(id);
		if(encounter.isPresent())
		{
			return encounter.get();
		}
		return null;
	}
	
	public Encounter updateEncounter(int id,Encounter encounter)
	{
		Encounter dbencounter=repo.findById(id).get();
		if(dbencounter !=null)
		{   
			 
		 
		   List<Branch> branch= dbencounter.getBranchs();
//		   List<Branch> branch2=new ArrayList<>();
//		   branch2.addAll(branch);
			encounter.setId(id);
			encounter.setPerson(dbencounter.getPerson());
			encounter.setBranchs(branch);
	 
			return repo.save(encounter);
		}
		return null;
	}
	public Encounter deleteEncounter(int id)
	{
		Optional<Encounter> encounter=repo.findById(id);
		if(encounter.isPresent())
		{   
			repo.deleteById(id);
			return encounter.get();
		}
		return null;
	}

}
