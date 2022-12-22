package com.example.demo.services.implemen;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repos.CRepo;
import com.example.demo.pojos.Customer;
import com.example.demo.services.CustomerService;
@Service
public class CustomerServiceImlementation implements CustomerService {
	@Autowired
	private CRepo repo;
	
	@Override
	public Integer saveCustomer(Customer cus) {
		cus = repo.save(cus);
		return cus.getId();
	}

	@Override
	public void updateCustomer(Customer cus) {
		repo.save(cus);
	}

	@Override
	public void deleteCustomer(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Optional<Customer> getOneCustomer(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

	@Override
	public boolean isCustomerExist(Integer id) {
		return repo.existsById(id);
	}
}
