package com.example.demo.services.implemen;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repos.BRepo;
import com.example.demo.pojos.Bids;
import com.example.demo.services.BidsService;
@Service
public class BidsServiceImplementation implements BidsService {
	@Autowired
	private BRepo repo;
	
	@Override
	public Integer saveBids(Bids bid) {
		bid = repo.save(bid);
		return bid.getId();
	}

	@Override
	public void updateBids(Bids bid) {
		repo.save(bid);
	}

	@Override
	public void deleteBids(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Bids> getOneBid(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<Bids> getAllBids() {
		return repo.findAll();
	}

	@Override
	public boolean isBidsExist(Integer id) {
		return repo.existsById(id);
	}


	}

