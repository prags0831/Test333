package com.example.demo.services.implemen;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repos.Repo;
import com.example.demo.pojos.Seller;
import com.example.demo.services.SellerService;
@Service
public class SellerServiceImplementation implements SellerService{
	@Autowired
	private Repo repo;
	
	@Override
	public Integer saveSeller(Seller seller) {
		seller = repo.save(seller);
		return seller.getId();
	}

	@Override
	public void updateSeller(Seller seller) {
		repo.save(seller);
	}

	@Override
	public void deleteSeller(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Seller> getOneSeller(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<Seller> getAllSellers() {
		return repo.findAll();
	}

	@Override
	public boolean isSellerExist(Integer id) {
		return repo.existsById(id);
	}
}
