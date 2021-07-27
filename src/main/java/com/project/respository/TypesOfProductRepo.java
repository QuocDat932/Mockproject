package com.project.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.*;

public interface TypesOfProductRepo extends JpaRepository<TypeOfProduct, Integer> {
	
	Optional<TypeOfProduct>  findBySlug(String slug);
}
