package com.project.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.dto.cartDetailDto;
import com.project.entity.OrderDetails;
@Repository
public interface OrderDetailrepo extends JpaRepository<OrderDetails, Integer> {
	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO order_details(orderId, productId, price, quantity) VALUES (:#{#dto.idOrder}, :#{#dto.idProduct}, :#{#dto.price}, :#{#dto.quantity})",
				 nativeQuery = true)
	void insert(@Param("dto") cartDetailDto dto);
}
