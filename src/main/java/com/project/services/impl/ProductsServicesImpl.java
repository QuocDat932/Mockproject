package com.project.services.impl;

import java.util.List;
import java.util.Optional;

import javax.naming.spi.DirStateFactory.Result;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Products;
import com.project.respository.ProductsRepository;
import com.project.services.ProductsServices;

@Service
public class ProductsServicesImpl implements ProductsServices{
	@Autowired
	private ProductsRepository repo;
	
	@Override
	public List<Products> findAllAvailable() {
		// TODO Auto-generated method stub
		return repo.findAllAvailable();
	}
	
	@Override
	public Products product(int typeID) {
		// TODO Auto-generated method stub
		Optional<Products> product = repo.findById(typeID);
		return product.isPresent() ? product.get() : null ;
	}
	
	@Override
	public List<Products> findByTypeId(Integer typeID) {
		// TODO Auto-generated method stub
		return repo.findByTypeId(typeID);
	}
	@Override
	public List<Products> findByTypeOfID_id(Integer id) {
		// TODO Auto-generated method stub
		return repo.findByTypeOfProduct_Id(id);
	}
	@Override
	public Products findByProductsSlug(String slug) {
		// TODO Auto-generated method stub
		Optional<Products> result = repo.findBySlug(slug);
		return result.isPresent() ? result.get() : null;
	}

	@Override
	public Products findById(int ID) {
		// TODO Auto-generated method stub
		Optional<Products> result = repo.findById(ID);
		return result.isPresent() ? result.get() : null;
	}
	@Override
	public void SaveAndUpdate(Products product) {
		// TODO Auto-generated method stub
		repo.saveAndFlush(product);
	}
	
	@Override
	@Transactional
	public void updateQuantity(Integer quantity, Integer id) {
		// TODO Auto-generated method stub
		repo.updateQuantity(quantity, id);
	}
	
}
