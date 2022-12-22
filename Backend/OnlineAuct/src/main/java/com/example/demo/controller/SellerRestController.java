package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Repos.Repo;
import com.example.demo.Utilities.SellerUtil;
import com.example.demo.pojos.Seller;
import com.example.demo.services.implemen.SellerServiceImplementation;

@RestController
@RequestMapping("/rest/seller")
@CrossOrigin(origins = "http://localhost:4200")
public class SellerRestController {
	
	private Logger log = LoggerFactory.getLogger(SellerRestController.class);
	@Autowired
	private SellerServiceImplementation service;
	@Autowired
	private SellerUtil util;
	@Autowired
	private Repo feed;

	/**
	 * 1. Read JSON(Student) and convert to Object Format
	 *    Store data in Database. Return one Message.
	 */
	@PostMapping("/save")
	public ResponseEntity<String> saveSeller(
			@RequestBody Seller seller)
	{
		log.info("Entered into method with Student data to save");

		ResponseEntity<String> resp = null;
		try {

			log.info("About to call save Operation");

			Integer id = service.saveSeller(seller);
			log.debug("Employee saved with id "+id);

			String body = "Seller '"+id+"' created";

			resp =  new ResponseEntity<String>(body,	HttpStatus.CREATED); //201

			log.info("Sucess response constructed");
		} catch (Exception e) {
			log.error("Unable to save Seller : problem is :"+e.getMessage());
			resp =  new ResponseEntity<String>(
					"Unable to Create Seller", 
					HttpStatus.INTERNAL_SERVER_ERROR); //500
			e.printStackTrace();
		}

		log.info("About to Exist save method with Response");
		return resp;
	}

	/**
	 * 2. Fetch all rows from database using Service
	 *    Sort data using name, return as JSON, 
	 *    else String message no data found.
	 *    
	 */
	@GetMapping("/all")
	public ResponseEntity<?> getAllSellers() {
		log.info("Entered into method to fetch Sellers data");
		ResponseEntity<?> resp = null ;
		try {

			log.info("About to call fetch student service");
			List<Seller> list = service.getAllSellers();
			if(list!=null && !list.isEmpty()) {
				log.info("Data is not empty=>"+list.size());
				System.out.println("list-----> "+list);
//				list.sort((s1,s2)->s1.getName().compareTo(s2.getName()));
				
				resp = new ResponseEntity<List<Seller>>(list, HttpStatus.OK);
			} else {
				log.info("No Seller exist: size "+list.size());

				//resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
				resp = new ResponseEntity<String>(
						"No Sellers Found",
						HttpStatus.OK);
			}
		} catch (Exception e) {
			log.error("Unable to fetch sellers : problem is :"+e.getMessage());

			resp =  new ResponseEntity<String>(
					"Unable to Fetch Sellers", 
					HttpStatus.INTERNAL_SERVER_ERROR); //500
			e.printStackTrace();
		}
		log.info("About to Exist fetch all method with Response");
		return resp;
	}


	/***
	 * 3. Get one student object based on ID (PathVariable). 
	 *   If Object exist then return Student object 
	 *   else provide message(String).
	 */
	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOneSeller(
			@PathVariable Integer id
			) 
	{
		log.info("Entered into Get one Seller method");
		ResponseEntity<?> resp = null;
		try {
			log.info("About to make service call to fetch one record");
			Optional<Seller> opt =  service.getOneSeller(id);
			if(opt.isPresent()) {
				log.info("Employee exist=>"+id);
				resp = new ResponseEntity<Seller>(opt.get(), HttpStatus.OK);
				//resp = ResponseEntity.ok(opt.get());
			} else {
				log.warn("Given Seller id not exist=>"+id);
				resp = new ResponseEntity<String>(
						"Seller '"+id+"' not exist", 
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Unable to process request fetch " + e.getMessage());
			resp = new ResponseEntity<String>(
					"Unable to process seller fetch", 
					HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;
	}


	/**
	 * 4. delete one row based on id (PathVariable)
	 *    First check given row exist or not?
	 *    if exist then call delete operation
	 *    else return  NO RECORD MESSAGE
	 *    
	 */

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeSeller(
			@PathVariable Integer id
			)
	{

		log.info("Entered into delete method");
		ResponseEntity<String> resp = null;

		try {

			log.info("About to make service call for data check");
			boolean exist = service.isSellerExist(id);
			if(exist) {
				service.deleteSeller(id);
				log.info("Seller exist with given id and deleted=>"+id);
				resp = new ResponseEntity<String>(
						"Seller '"+id+"' deleted",
						HttpStatus.OK);
			} else {
				log.warn("Given Seller id not exist =>"+id);
				resp = new ResponseEntity<String>(
						"Seller '"+id+"' not exist",
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Unable to perform Delete Operation =>" + e.getMessage());
			resp = new ResponseEntity<String>(
					"Unable to delete", 
					HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;
	}

	/**
	 * 5. Update
	 */
	@PutMapping("/modify/{id}")
	public ResponseEntity<String> updateSeller(
			@PathVariable Integer id,
			@RequestBody Seller seller
			)
	{
		log.info("Entered into Update method");

		ResponseEntity<String> resp =null;

		try {
			log.info("About to check given id exist or not db");
			Optional<Seller> opt =  service.getOneSeller(id);
			if(opt.isPresent()) {
				log.info("Seller present in database");
				Seller actual = opt.get();
				util.mapToActualObject(actual,seller);
				service.updateSeller(actual);
				resp = new ResponseEntity<String>(
						"Seller '"+id+"' Updated", 
						//HttpStatus.RESET_CONTENT
						HttpStatus.OK
						);
				log.info("Seller update done successfully");
			} else {
				log.info("Seller not exist=>"+id);
				resp = new ResponseEntity<String>(
						"Seller '"+id+"' not found", 
						//HttpStatus.RESET_CONTENT
						HttpStatus.BAD_REQUEST
						);
			}

		} catch (Exception e) {
			log.error("Unable to perform Update Operation=>" + e.getMessage() );
			resp = new ResponseEntity<String>(
					"Unable to process Update",
					HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;
	}

	
	
}
