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
			Optional<Users> result = repoUS.findById(21);
			Users user = result.isPresent()? result.get() : null;
			System.out.println(user.getFullname() +"ID = "+ user.getId());
			order.setUser(user);
			//System.out.println(order.getUser().getId() + "\nBefore Save and flush");
			return repo.saveAndFlush(order);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
