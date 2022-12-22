package com.example.demo.Repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojos.Seller;

public interface Repo extends JpaRepository<Seller,Integer>{

}

