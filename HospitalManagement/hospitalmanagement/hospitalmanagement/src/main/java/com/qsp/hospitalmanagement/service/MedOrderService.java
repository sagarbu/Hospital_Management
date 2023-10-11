package com.qsp.hospitalmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.hospitalmanagement.dao.MedOrderDao;
import com.qsp.hospitalmanagement.dto.MedOrder;
import com.qsp.hospitalmanagement.exception.IdNotFound;
import com.qsp.hospitalmanagement.util.ResponseStructure;

@Service
public class MedOrderService {
	
	@Autowired
	private MedOrderDao dao;
	
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder order,int eid)
	{   
		ResponseStructure<MedOrder> structure=new ResponseStructure<>();
		structure.setMessage("Data Saved Successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveMedOrder(order, eid));
		return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> findMedOrder(int id)
	{
		ResponseStructure<MedOrder> structure=new ResponseStructure<>();
		MedOrder order= dao.findMedOrder(id);
		if(order!=null)
		{
		structure.setMessage("Found Successfully");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(order);
		return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.FOUND);
		}
		else
		{
			 throw new IdNotFound("Id Not Found");
		}
		 
		
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(int id,MedOrder order)
	{
		ResponseStructure<MedOrder> structure=new ResponseStructure<>();
		MedOrder dborder= dao.findMedOrder(id);
		if(dborder!=null)
		{   
			order.setId(id);
			structure.setMessage("Data Updated Successfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateMedOrder(id, order));
			return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.OK);
			
		}
		else
		{
			 throw new IdNotFound("Id Not Found");
		}
	 
		
	}
	
	public ResponseEntity<ResponseStructure<MedOrder>> deleteMedOrder(int id)
	{
		ResponseStructure<MedOrder> structure=new ResponseStructure<>();
		MedOrder order= dao.findMedOrder(id);
		if(order!=null)
		{
		structure.setMessage("Deleted Successfully");
		structure.setStatus(HttpStatus.OK.value());
		dao.deleteMedOrder(id);
		structure.setData(order);
		return new ResponseEntity<ResponseStructure<MedOrder>>(structure,HttpStatus.OK);
		}
		else
		{
			throw new IdNotFound("Id Not Found");
		}
		
		
	}

}
