package com.example.demo.Utilities;

import org.springframework.stereotype.Controller;

import com.example.demo.pojos.Seller;



@Controller
public class SellerUtil {

	public void mapToActualObject(Seller  actual, Seller seller) {
		
		actual.setId(seller.getId());
		actual.setName(seller.getName());
		actual.setEmail(seller.getEmail());
		actual.setPassword(seller.getPassword());
		actual.setCategory(seller.getCategory());
		actual.setProduct(seller.getProduct());
	}
}
