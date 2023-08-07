package com.nitheesh.restfulwebservices.Entity;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class Users {

	
	private long id;
	
	@Size(min = 2)
	private String name;
	
	@Past
	private LocalDate birthdate;

	public Users(long id, String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
	
	
	public Users() {
		
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}
	
	
	
	
}
