package com.project.dto;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class cartDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String address;
	private String phone;
	private Timestamp createDate;
	private HashMap<Integer, cartDetailDto> listDetail = new HashMap<>();
	private int totalQuantity = 0;
	private Double totalPrice = 0D;
}
