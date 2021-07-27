package com.project.services.impl;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Products;
import com.project.entity.TypeOfProduct;
import com.project.entity.Users;
import com.project.services.*;
import com.project.respository.*;

@Service
public class TypeOfProductImpl implements TypeOfProductServices{
	
	@Autowired
	private TypesOfProductRepo repo;
	
	@Override
	public TypeOfProduct findBySlug(String flug) {
		Optional<TypeOfProduct> result = repo.findBySlug(flug);
		return result.isPresent() ? result.get() : null;
	}
}
