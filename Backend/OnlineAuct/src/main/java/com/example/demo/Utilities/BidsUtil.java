package com.example.demo.Utilities;

import org.springframework.stereotype.Controller;

import com.example.demo.pojos.Bids;

@Controller
public class BidsUtil {
public void mapToActualObject(Bids  actual, Bids bid) {
		
		actual.setId(bid.getId());
		actual.setProducts(bid.getProducts());
		actual.setValue(bid.getValue());
	}
}
