package com.qsp.hospitalmanagement.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospitalmanagement.dto.MedOrder;
import com.qsp.hospitalmanagement.repo.MedOrderRepo;

@Repository
public class MedOrderDao {
	
	@Autowired
	private MedOrderRepo repo;
	
	@Autowired
	private EncounterDao dao;
	
	public MedOrder saveMedOrder(MedOrder order,int eid)
	{   
		order.setEncounter(dao.findEncounter(eid));
		return repo.save(order);
	}
	
	public MedOrder findMedOrder(int id)
	{
		Optional<MedOrder> order=repo.findById(id);
		if(order.isPresent())
		{
			return order.get();
		}
		return null;
	}
	
	public MedOrder updateMedOrder(int id,MedOrder order)
	{
		MedOrder dborder=repo.findById(id).get();
		if(dborder!=null)
		{   
			order.setId(id);
			order.setEncounter(dborder.getEncounter());
			return repo.save(order);
		}
		return null;
	}
	
	public MedOrder deleteMedOrder(int id)
	{
		Optional<MedOrder> order=repo.findById(id);
		if(order.isPresent())
		{
			repo.deleteById(id);
			return order.get();
		}
		return null;
	}
	

}
