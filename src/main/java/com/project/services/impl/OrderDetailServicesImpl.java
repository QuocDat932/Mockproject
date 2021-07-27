package com.project.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.cartDetailDto;
import com.project.respository.OrderDetailrepo;
import com.project.services.OrderDetailServices;
@Service
public class OrderDetailServicesImpl implements OrderDetailServices{
	@Autowired
	private OrderDetailrepo repo;
	@Override
	@Transactional
	public void insert(cartDetailDto cartDetailDto) throws Exception {
		repo.insert(cartDetailDto);
		
	}
}
