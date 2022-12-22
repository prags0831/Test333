package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.pojos.Seller;

public interface SellerService {

	Integer saveSeller(Seller seller);
	void updateSeller(Seller seller);
	void deleteSeller(Integer id);
	Optional<Seller> getOneSeller(Integer id);
	List<Seller> getAllSellers();
	boolean isSellerExist(Integer id);
}
