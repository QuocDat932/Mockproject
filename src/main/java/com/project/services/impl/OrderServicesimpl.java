package com.project.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Orders;
import com.project.entity.Users;
import com.project.respository.OrderRepo;
import com.project.respository.UsersRepository;
import com.project.services.Orderservices;
@Service
public class OrderServicesimpl implements Orderservices{
	@Autowired
	private OrderRepo repo;
	@Autowired
	private UsersRepository repoUS;
	@Override
	@Transactional
	public Orders insert(Orders order) throws Exception {
		try {
			repo.saveAndFlush(order);
			Orders latOrder = repo.LastOrder();
			return latOrder;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
