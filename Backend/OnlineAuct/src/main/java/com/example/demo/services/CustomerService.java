package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.pojos.Customer;

public interface CustomerService {
	Integer saveCustomer(Customer cus);
	void updateCustomer(Customer cus);
	void deleteCustomer(Integer id);
	Optional<Customer> getOneCustomer(Integer id);
	List<Customer> getAllCustomers();
	boolean isCustomerExist(Integer id);
}
