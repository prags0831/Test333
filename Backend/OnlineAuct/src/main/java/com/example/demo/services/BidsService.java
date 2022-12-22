package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.pojos.Bids;



public interface BidsService {
	Integer saveBids(Bids bid);
	void updateBids(Bids bid);
	void deleteBids(Integer id);
	Optional<Bids> getOneBid(Integer id);
	List<Bids> getAllBids();
	boolean isBidsExist(Integer id);
}
