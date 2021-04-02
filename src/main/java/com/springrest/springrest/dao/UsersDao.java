package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springrest.springrest.entities.Users;

public interface UsersDao extends JpaRepository<Users , Long> {
  
	public Users findByUseremailAndUserpassword(String useremail, String userpassword);
}
