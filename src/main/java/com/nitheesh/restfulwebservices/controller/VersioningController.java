package com.nitheesh.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nitheesh.restfulwebservices.Entity.Name;
import com.nitheesh.restfulwebservices.Entity.Person1;
import com.nitheesh.restfulwebservices.Entity.Person2;

@RestController
public class VersioningController {
	
	@GetMapping("/v1/person")
	public Person1 version1() {
		
		return new Person1("nitheesh");
	}
	
	@GetMapping("/v2/person")
	public Person2 version2() {
		return new Person2(new Name("nitheesh", "mandadi"));
	}
	
	@GetMapping(path = "/person",params = "version=1")
	public Person1 versionrequestparameter() {
		return new Person1("nitheesh");
	}
	
	@GetMapping(path = "/person",params = "version=2")
	public Person2 versionrequestparameter2() {
		return new Person2(new Name("nitheesh","mandadi"));
	}
	
	@GetMapping(path = "/person/header",headers = "x-api-version=1")
	public Person1 versionheader() {
		return new Person1("nitheesh");
	}
	
	@GetMapping(path = "/person/header",headers = "x-api-version=2")
	public Person2 versionheader2() {
		return new Person2(new Name("mandadi","nitheesh"));
	}
	
	

}
