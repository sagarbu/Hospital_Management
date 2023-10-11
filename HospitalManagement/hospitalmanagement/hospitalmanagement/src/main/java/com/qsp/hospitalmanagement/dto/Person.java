package com.qsp.hospitalmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Person {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message="Name cant be blank")
	@NotNull(message="Name cant be null")
	private String name;
	@Column(unique = true)
	@Email(regexp = "[a-z0-9_.%$-+]+@[a-z]+\\.[a-z]{2,3}" ,message = "Invalid Email")
	private String email;
	@Column(unique = true)
	private long phoneno;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	
	

}
