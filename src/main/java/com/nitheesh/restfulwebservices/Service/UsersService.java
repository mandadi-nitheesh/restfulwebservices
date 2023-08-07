package com.nitheesh.restfulwebservices.Service;

import java.util.List;

import com.nitheesh.restfulwebservices.Entity.Users;

public interface UsersService {
	
	public List<Users> getallUsers();
	
	public Users addUsers(Users users);
	
    public Users findone(long id);
    
    public void deleteuser(long id);
    
    
    public Users getindividual(long id);
	
}
