package com.nitheesh.restfulwebservices.Entity;

public class Person1 {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person1(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person1 [name=" + name + "]";
	}
	
	
	
	
}
