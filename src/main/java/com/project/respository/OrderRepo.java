package com.project.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Orders;
@Repository
public interface OrderRepo extends JpaRepository<Orders, Integer>{

}
