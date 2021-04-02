package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.entities.Users;

public interface UsersService {

	public Users userRegistration(Users userData); 
	///public Users userAuthentication(Users userCredentials);
	//public Users getUserByEmail(String Email);

	public Users userLogin(Users userData);

	public List<Users> getUsers();
	
	//public List<Course> getCourses(); 
		public List<Users> users( int pageNo ); 
		public Users getUserById(long parseLong);
		public Users updateUserById(Users userData);
		public void deleteUserById(long parseLong);

	//public Users updateUser(Users userData);
	
	
}
