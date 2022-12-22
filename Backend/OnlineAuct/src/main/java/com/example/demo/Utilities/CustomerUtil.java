package com.example.demo.Utilities;

import org.springframework.stereotype.Controller;


import com.example.demo.pojos.Customer;

@Controller
public class CustomerUtil {
public void mapToActualObject(Customer  actual, Customer cus) {
		
		actual.setId(cus.getId());
		actual.setName(cus.getName());
		actual.setEmail(cus.getEmail());
		actual.setPassword(cus.getPassword());
		actual.setCategory(cus.getCategory());
		actual.setProduct(cus.getProduct());
	}


	

}
