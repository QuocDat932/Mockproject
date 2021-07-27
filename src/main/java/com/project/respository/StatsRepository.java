package com.project.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.entity.Orders;
@Repository
public interface StatsRepository extends JpaRepository<Orders, Integer>{
	@Query(value = "{CALL sp_getTotalPriceOneMonth(:month, :year)}", nativeQuery = true)
	String getTotalPriceByMonth(@Param("month") String month, 
			@Param("year") String year);
}
