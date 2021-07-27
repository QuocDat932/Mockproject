package com.project.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entity.Orders;
@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer>{
	@Query(value = "SELECT id, createddate, address, phone, userid FROM orders WHERE id = (SELECT MAX(id) FROM orders)",nativeQuery = true)
	Orders LastOrder();
}
