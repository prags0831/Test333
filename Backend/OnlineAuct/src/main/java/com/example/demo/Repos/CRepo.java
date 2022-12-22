package com.example.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojos.Customer;


public interface CRepo extends JpaRepository<Customer,Integer> {

}
