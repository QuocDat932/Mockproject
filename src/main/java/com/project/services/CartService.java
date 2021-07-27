package com.project.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.project.dto.*;
import com.project.entity.Users;

public interface CartService {
	
	cartDto updateProduct(cartDto cart, int idProduct, int quantity, boolean isUpdate);
	Integer getTotalQuantity(cartDto cart);
	Double getTotalPrice(cartDto cart);
	
	//void myshop(cartDto cart);
	HashMap<Integer, cartDetailDto> myshop(cartDto cart);
	
	void insert(cartDto cart, Users user, String address, String phone) throws Exception;
}
