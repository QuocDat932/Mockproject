package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.services.*;
import com.project.entity.*;
import com.project.constant.*;
@Controller
@RequestMapping("/sanpham")
public class ProductsController {
	@Autowired
	private ProductsServices productservices;
	@Autowired
	private TypeOfProductServices typeOfProductservices;

	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
	@GetMapping("/{typeSlug}")
	public String dogetProductTypeSlug(Model model, @PathVariable("typeSlug") String typeSlug) {
		System.out.println(typeSlug);
		TypeOfProduct type = typeOfProductservices.findBySlug(typeSlug);
		if(ObjectUtils.isEmpty(type)) {
			model.addAttribute("errorMsg","Không Thấy Sản Phẩm Này");
			System.out.println("Không Thấy Sản Phẩm Này");
			return "home/index";
		}
		else {
			List<Products> sp =  productservices.findByTypeOfID_id(type.getId());
			model.addAttribute("listProduct", sp);
			System.out.println(sp.get(0).getName());
			return "home/index";//"home/TypeOfProduct";
		}
	}
	@GetMapping({"{dien-thoai}/detail/{Productslug}","{lap-top}/detail/{Productslug}"})
	public String dogetDetailProduct(Model model, @PathVariable("Productslug") String Productslug) {
		System.out.println(Productslug);
		System.out.println(111);
		Products details = productservices.findByProductsSlug(Productslug);
		if(ObjectUtils.isEmpty(details)) {
			model.addAttribute("errorMsg","Không Thấy Sản Phẩm Này");
			System.out.println("Không Thấy Sản Phẩm Này");
			return "home/index3";
		}
		else {
			model.addAttribute("product", details);
			return "home/detail";
			
		}
	}
	@GetMapping("/sanpham/AddToCart/{idproduct}")
	public String doGetAddtocart(Model model, @PathVariable("idproduct") Integer id) {
		System.out.println(id);
		Products mua = productservices.findById(id);
		System.out.println(mua.getName());
		System.out.println("**************");
		return "redirect:/*/detail";
	}
}
