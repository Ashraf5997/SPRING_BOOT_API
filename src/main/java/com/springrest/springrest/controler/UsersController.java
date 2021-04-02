package com.springrest.springrest.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.entities.Users;
import com.springrest.springrest.services.UsersService;

@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;
	//private Object ;
	
	// POST REGISTRATION
		@PostMapping("/userRegistration")
		public ResponseEntity<Users>userRegistration(@RequestBody Users userData)
		{
			try {
					 usersService.userRegistration(userData);
					 return new ResponseEntity<>(HttpStatus.CREATED);
				
			}catch(Exception e) {
				
				 return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		}
		
	// POST LOGIN
				@PostMapping("/userLogin")
				public  ResponseEntity<Users>  userLogin(@RequestBody Users userData)
				{
					try {
							Users data = usersService.userLogin(userData);
							// return new ResponseEntity<>(HttpStatus.CREATED);
							return ResponseEntity.of(Optional.of(data));	
					}catch(Exception e) {
						 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
					}
					
						//Users userdata= usersService.userLogin(userData);
						//return userdata;
					
				}
				
				@GetMapping("/ourusers")
				public ResponseEntity<List<Users>> getAllUsers()
				{
					List<Users>list=usersService.getUsers();
					if(list.size()<=0)
					{
						return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
					}
					return ResponseEntity.of(Optional.of(list));
					
				}
				
				
	// update course
			/*	@PutMapping("/updateUsers")
				public ResponseEntity<Users> updateUsers(@RequestBody Users userData)
				{
					 try {
						Users data = usersService.updateUser(userData);
						// return new ResponseEntity<>(HttpStatus.CREATED);
						return ResponseEntity.of(Optional.of(data));
					
			    	}catch(Exception e) {
					
					
					 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
				}
					
				}	*/
				
				@GetMapping("/users/{pageNo}")
				public ResponseEntity<List<Users>> users(@PathVariable int  pageNo)
				{
					//Pageable pageable = PageRequest.of(page, 5);
				//	l courseService.getCourses(pageNo);
					List<Users>list=usersService.users(pageNo);
					if(list.size()<=0)
					{
						return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
					}
					return ResponseEntity.of(Optional.of(list));
					
					
				}
				
				// get single user
				@GetMapping("/getUserById/{userId}")
				public  Users getuser( @PathVariable String userId )
				{   
					return this.usersService.getUserById(Long.parseLong(userId));
				}
				
				// update single user
				@PutMapping("/updateUser")
				public Users updateUserById(@RequestBody Users userData)
				{
						return this.usersService.updateUserById(userData);
					
				}	
				
				// delete user by Id
				@DeleteMapping("/deleteUserById/{userId}")
				public ResponseEntity <HttpStatus> deleteUserById (@PathVariable String userId)
				{
				 try {   
						    this.usersService.deleteUserById(Long.parseLong(userId));
							return new ResponseEntity<>(HttpStatus.OK);
							
					}catch(Exception e) {
							return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					}
					
				}			
				
				
	
				
				
				
				
				
}
