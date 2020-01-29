package com.distribuida.dto;

import java.io.Serializable;
import java.util.Date;

public class Singer implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String firstName;

	private String lastName;

	private Date birthDate;
	
	public Singer() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
