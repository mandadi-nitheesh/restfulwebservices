package com.nitheesh.restfulwebservices.Entity;

public class Person2 {

	private Name name;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person2 [name=" + name + "]";
	}

	public Person2(Name name) {
		super();
		this.name = name;
	}
	
	
	
	
}
