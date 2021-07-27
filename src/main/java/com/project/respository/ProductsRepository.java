package com.project.respository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project.entity.*;

@Repository								
public interface ProductsRepository extends JpaRepository<Products, Integer>{
	//List<Products> findByTypeId(Integer TypeId);
	@Query(value = " SELECT * FROM products Where isDeleted = 0", nativeQuery = true)
	List<Products> findAllAvailable();
	
	@Query(value="SELECT * FROM products WHERE typeId = ?1", nativeQuery = true)
	List<Products> findByTypeId(Integer typeID);
	
	List<Products> findByTypeOfProduct_Id(Integer id);
	
	Optional<Products> findBySlug(String slug);
	
	@Modifying(clearAutomatically = true)
	@Query(value=" UPDATE products SET quantity = ?1 Where id = ?2", nativeQuery = true)
	void updateQuantity(Integer quantity, Integer ID);
	
/*
 * ----------------------------------->1
 @Query(value = " SELECT * FROM product Where isDeleted = 0 ?1 and price = ?2", nativeQuery = true)
	List<Products> findAllAvailable();
 * ----------------------------------------->2
 @Modifying(clearAutomatically = true)
 @Query(value = "INSERT INTO booking(userId, tableId, bookedTime, bookedStatus, startTime) VALUES "
			+ "(:#{#dto.userId}, :#{#dto.tableId}, :#{#dto.bookedTime}, "
			+ ":#{#dto.bookedStatus}, :#{#dto.startTime})",
			nativeQuery = true)
	void insertByDto(BookingDto dto);
 */

}
