package com.nitheesh.restfulwebservices.ServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.nitheesh.restfulwebservices.Entity.Users;
import com.nitheesh.restfulwebservices.Exceptions.UserNotFoundException;
import com.nitheesh.restfulwebservices.Service.UsersService;

@Service
public class UsersServiceImpl  implements UsersService{
	
	//implementing using static list...
	
	private static List<Users> users=new ArrayList<>();
	private static int usercount=0;
	
	static{
		users.add(new Users(++usercount,"nitheesh",LocalDate.now().minusYears(30)));
		users.add(new Users(++usercount,"vazeem",LocalDate.now().minusYears(25)));
		users.add(new Users(++usercount,"naveen",LocalDate.now().minusYears(20)));
	}

	@Override
	public List<Users> getallUsers() {
		return users;
	}

	@Override
	public Users addUsers(Users user) {
		user.setId(++usercount);
		UsersServiceImpl.users.add(user);
		return user;
	}

	@Override
	public Users findone(long id) {
		  return users.stream().filter(user -> user.getId()==id)
				  .findFirst().orElseThrow(()-> new UserNotFoundException(String.format("the current id %s is not valid",id)) );
		 
	}

	@Override
	public void deleteuser(long id) {
		
		Predicate<? super Users> predicate=user -> user.getId()==id;
		
		users.removeIf(predicate);
		
	}

	@Override
	public Users getindividual(long id) {
	return	users.stream().filter(user -> user.getId()==id).findFirst().get();
		
		
	}
	
	
	
	
	

}
