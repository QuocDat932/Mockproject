package com.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.constant.SessionConst;
import com.project.dto.cartDto;
import com.project.services.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	@GetMapping("")
	public String doGetViewCart(Model model, HttpSession session) {
		cartDto currentCart = (cartDto) session.getAttribute(SessionConst.CURRENT_CART);
		if(ObjectUtils.isEmpty(currentCart)) {
			session.setAttribute("currentCart", new cartDto());
		}
		return "home/cart";
	}
	@GetMapping("/update")
	public String doGetUpdateCart(
			@RequestParam("product") Integer productId,
			@RequestParam("quantity") Integer quantity,
			@RequestParam("isUpdate") Boolean isUpdate,
			HttpSession session) {
		cartDto currentCart = (cartDto) session.getAttribute(SessionConst.CURRENT_CART);
		currentCart = cartService.updateProduct(currentCart, productId, quantity, isUpdate);
		return "home/cart::#viewCartFragment";
	}
}
