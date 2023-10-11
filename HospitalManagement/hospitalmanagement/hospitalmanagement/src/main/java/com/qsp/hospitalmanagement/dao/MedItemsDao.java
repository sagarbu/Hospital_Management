package com.qsp.hospitalmanagement.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.hospitalmanagement.dto.MedItems;
import com.qsp.hospitalmanagement.repo.MedItemsRepo;

@Repository
public class MedItemsDao {
	
    @Autowired
	private MedItemsRepo repo;
    
    @Autowired
    private MedOrderDao dao;
    
    public MedItems saveMedItems(MedItems items,int mod)
    {   
    	items.setMedOrder(dao.findMedOrder(mod));
    	return  repo.save(items);
    }
    
    public MedItems findMedItems(int id)
    {
    	Optional<MedItems> items=repo.findById(id);
    	if(items.isPresent())
    	{
    		return items.get();
    	}
    	return null;
    }
    
    public MedItems updateMedItems(int id,MedItems items)
    {
    	MedItems dbitems=repo.findById(id).get();
    	if(dbitems!=null)
    	{  
    		items.setId(id);
    		items.setMedOrder(dbitems.getMedOrder());
    		return repo.save(items);
    	}
    	return null;
    }
    
    public MedItems deleteMedItems(int id)
    {
    	Optional<MedItems> items=repo.findById(id);
    	if(items.isPresent())
    	{
    		repo.deleteById(id);
    		return items.get();
    	}
    	return null;
    }
    
    

}
