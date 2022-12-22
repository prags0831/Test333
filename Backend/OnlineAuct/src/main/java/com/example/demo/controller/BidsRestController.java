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

import com.example.demo.Repos.BRepo;
import com.example.demo.Utilities.BidsUtil;
import com.example.demo.pojos.Bids;

import com.example.demo.services.implemen.BidsServiceImplementation;


@RestController
@RequestMapping("/rest/bid")
@CrossOrigin(origins = "http://localhost:4200")
public class BidsRestController {

	private Logger log = LoggerFactory.getLogger(BidsRestController.class);
	@Autowired
	private BidsServiceImplementation service;
	
	@Autowired
	private BRepo feed;
	@Autowired
	private BidsUtil util;

	/**
	 * 1. Read JSON(Student) and convert to Object Format
	 *    Store data in Database. Return one Message.
	 */
	@PostMapping("/save")
	public ResponseEntity<String> saveBids(
			@RequestBody Bids bid)
	{
		log.info("Entered into method with Student data to save");

		ResponseEntity<String> resp = null;
		try {

			log.info("About to call save Operation");

			Integer id = service.saveBids(bid);
			log.debug("Bids saved with id "+id);

			String body = "bids'"+id+"' created";

			resp =  new ResponseEntity<String>(body,	HttpStatus.CREATED); //201

			log.info("Sucess response constructed");
		} catch (Exception e) {
			log.error("Unable to save bid : problem is :"+e.getMessage());
			resp =  new ResponseEntity<String>(
					"Unable to Create Bid", 
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
	public ResponseEntity<?> getAllBids() {
		log.info("Entered into method to fetch Bids data");
		ResponseEntity<?> resp = null ;
		try {

			log.info("About to call fetch student service");
			List<Bids> list = service.getAllBids();
			if(list!=null && !list.isEmpty()) {
				log.info("Data is not empty=>"+list.size());
				System.out.println("list-----> "+list);
//				list.sort((s1,s2)->s1.getName().compareTo(s2.getName()));
				
				resp = new ResponseEntity<List<Bids>>(list, HttpStatus.OK);
			} else {
				log.info("No Bids exist: size "+list.size());

				//resp = new ResponseEntity<>(HttpStatus.NO_CONTENT);
				resp = new ResponseEntity<String>(
						"No Bid Found",
						HttpStatus.OK);
			}
		} catch (Exception e) {
			log.error("Unable to fetch customer : problem is :"+e.getMessage());

			resp =  new ResponseEntity<String>(
					"Unable to Fetch Bids", 
					HttpStatus.INTERNAL_SERVER_ERROR); //500
			e.printStackTrace();
		}
		log.info("About to Exist fetch all method with Response");
		return resp;
	}


	/***
	 * 3. Get one  object based on ID (PathVariable). 
	 *   If Object exist then return  object 
	 *   else provide message(String).
	 */
	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOneCustomer(
			@PathVariable Integer id
			) 
	{
		log.info("Entered into Get one Customer method");
		ResponseEntity<?> resp = null;
		try {
			log.info("About to make service call to fetch one record");
			Optional<Bids> opt =  service.getOneBid(id);
			if(opt.isPresent()) {
				log.info("Customer exist=>"+id);
				resp = new ResponseEntity<Bids>(opt.get(), HttpStatus.OK);
				//resp = ResponseEntity.ok(opt.get());
			} else {
				log.warn("Given Customer id not exist=>"+id);
				resp = new ResponseEntity<String>(
						"Bid '"+id+"' not exist", 
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("Unable to process request fetch " + e.getMessage());
			resp = new ResponseEntity<String>(
					"Unable to process bid fetch", 
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
	public ResponseEntity<String> removebid(
			@PathVariable Integer id
			)
	{

		log.info("Entered into delete method");
		ResponseEntity<String> resp = null;

		try {

			log.info("About to make service call for data check");
			boolean exist = service.isBidsExist(id);
			if(exist) {
				service.deleteBids(id);
				log.info("Bid exist with given id and deleted=>"+id);
				resp = new ResponseEntity<String>(
						"Bid '"+id+"' deleted",
						HttpStatus.OK);
			} else {
				log.warn("Given Customer id not exist =>"+id);
				resp = new ResponseEntity<String>(
						"Bid '"+id+"' not exist",
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
	public ResponseEntity<String> updateBid (
			@PathVariable Integer id,
			@RequestBody Bids bid
			)
	{
		log.info("Entered into Update method");

		ResponseEntity<String> resp =null;

		try {
			log.info("About to check given id exist or not db");
			Optional<Bids> opt =  service.getOneBid(id);
			if(opt.isPresent()) {
				log.info("Bid  present in database");
				Bids actual = opt.get();
				util.mapToActualObject(actual,bid);
				service.updateBids(actual);
				resp = new ResponseEntity<String>(
						"Bid '"+id+"' Updated", 
						//HttpStatus.RESET_CONTENT
						HttpStatus.OK
						);
				log.info("Bid update done successfully");
			} else {
				log.info("Bid not exist=>"+id);
				resp = new ResponseEntity<String>(
						"Bid '"+id+"' not found", 
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
