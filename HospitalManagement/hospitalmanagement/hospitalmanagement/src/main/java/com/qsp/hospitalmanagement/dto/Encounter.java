package com.qsp.hospitalmanagement.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Entity
public class Encounter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="Reason cant be blank")
	@NotNull(message="Reason cant be null")
	private String reason;
	private double cost;
	@ManyToOne(cascade = CascadeType.ALL)
	private Person person;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Branch> branchs;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<Branch> getBranchs() {
		return branchs;
	}
	public void setBranchs(List<Branch> branchs) {
		this.branchs = branchs;
	}
	
	

}
