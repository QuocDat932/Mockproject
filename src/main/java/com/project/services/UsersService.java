package com.project.services;

import java.util.*;
import com.project.entity.*;
public interface UsersService {
	List<Users> findAll();
	
	Users findByfullname(String fullname);
	
	Users findByid(int id);
	
	Users findByUsernameAndHashPassword(String username, String hashpassword);
	
	Users findByEmail(String email);
	
	void addUser(Users user);
	
	List<Users> UserHaveRoles(List<roles> roles);
	
	Users findByUserName(String findByUserName);
	void delete(Users user);
}
