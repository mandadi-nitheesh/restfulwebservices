package com.nitheesh.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nitheesh.restfulwebservices.Entity.Users;
import com.nitheesh.restfulwebservices.Service.UsersService;

import jakarta.validation.Valid;

@RestController
public class Userscontroller {

	@Autowired
	private UsersService usersService;
	
	@GetMapping("/users")
	public List<Users> getallUsers(){
		return usersService.getallUsers();
	}
	
	@PostMapping("/users")
	public ResponseEntity<Users> adduser(@Valid   @RequestBody Users users) {
		
		Users user=usersService.addUsers(users);
		
		URI locationUri=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId()).toUri();
		
	   return ResponseEntity.created(locationUri).body(user);
	}
	
	@GetMapping("/users/{id}")
	public Users getspecificUser(@PathVariable("id") long id ) {
		
		return usersService.findone(id);
	}
	
	@DeleteMapping("/users/{id}")
	public void deletuser( @PathVariable("id") long id) {
		
		usersService.deleteuser(id);
	}
	
	@GetMapping("/hateos/{id}")
	public EntityModel<Users> getindividual(@PathVariable("id") long id){
		
		Users user=usersService.getindividual(id);
		
		EntityModel<Users> entityModel=EntityModel.of(user);
		
		WebMvcLinkBuilder webMvcLinkBuilder=WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn(this.getClass()).getallUsers()
				
				);
		
		entityModel.add(webMvcLinkBuilder.withRel("all-users"));
		
		return entityModel;
	}
	
	
	
}
