package com.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.roles;
import com.project.respository.RolesRepository;
import com.project.services.RolesServices;
@Service
public class RolesServicesImpl implements RolesServices {
	@Autowired
	private RolesRepository rolesRepo;
	@Override
	public List<roles> findAll() {
		// TODO Auto-generated method stub
		return rolesRepo.findAll();
	}
	@Override
	public roles findByUserID(int Roles_ID) {
		// TODO Auto-generated method stub
		return rolesRepo.findById(Roles_ID);
	}
}
