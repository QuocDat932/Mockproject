package com.project.api;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.constant.SessionConst;
import com.project.dto.cartDetailDto;
import com.project.dto.cartDto;
import com.project.entity.Users;
import com.project.services.*;
@RestController
@RequestMapping("/api/cart")
public class CartApi {
	@Autowired
	private CartService cartServices;
	@GetMapping("/update")
	public ResponseEntity<?> dogetUpdateCart(
		@RequestParam("product") Integer productId,
		@RequestParam("quantity")Integer quantity,
		@RequestParam("isUpdate") Boolean isUpdate,
		HttpSession session)	{
		cartDto currentCart = (cartDto) session.getAttribute(SessionConst.CURRENT_CART);
		currentCart = cartServices.updateProduct(currentCart, productId, quantity, isUpdate);
		//System.out.println(currentCart.getListDetail().get(4).getName());
		return ResponseEntity.ok(currentCart);
		
	}
	@GetMapping("/refresh")
	public ResponseEntity<?> dogetRefeshCart(HttpSession session){
		cartDto currentCart = (cartDto) session.getAttribute(SessionConst.CURRENT_CART);
		System.out.println(currentCart.getTotalQuantity());
		return ResponseEntity.ok(currentCart);	
		
	}
	@GetMapping("/checkout")
	public ResponseEntity<?> dogetCheckOut(@RequestParam("address") String address,
										   @RequestParam("phone") String phone,
										   HttpSession session){
		Users currentUser = (Users) session.getAttribute(SessionConst.CURRENT_USER);
		if(ObjectUtils.isEmpty(currentUser)) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN); // 403: k co quyen
		}
		else {
			cartDto currentCart = (cartDto) session.getAttribute(SessionConst.CURRENT_CART);
			//System.out.println(currentUser.getFullname());
			try {
				cartServices.insert(currentCart, currentUser, address, phone);
				session.setAttribute(SessionConst.CURRENT_CART, new cartDto());
				return new ResponseEntity<>(HttpStatus.CREATED);
			} catch (Exception e) {
				System.out.println(111);
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		
		
	}
}





