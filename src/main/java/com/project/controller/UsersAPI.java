package com.project.controller;
// return type of date is JS
import com.project.services.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.*;
@RestController
@RequestMapping("/api/user")
public class UsersAPI {
	
	@Autowired
	private UsersService service;
	// đưa về inteface service
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") int id){
		Users result = service.findByid(id);
		return ResponseEntity.ok(result);
		// API return : data + status
	}
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		List<Users> result = service.findAll();
		return ResponseEntity.ok(result);
		
	}
	@GetMapping("/gmail/{gmail}")
	public ResponseEntity<?> getUserBtEmail(@PathVariable("gmail") String gmail){
		Users result = service.findByEmail(gmail);
		return ResponseEntity.ok(result);
	}
}
