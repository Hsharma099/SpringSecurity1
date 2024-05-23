package com.example.bank_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank_security.model.Customer;
import com.example.bank_security.repository.CustomerRepository;

@RestController
public class LoginController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	/*
	 * This method is registring new user
	 */

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer){
		
		Customer savedCustomer = null;
		ResponseEntity response = null;
		try {
			savedCustomer = customerRepository.save(customer);
			if (savedCustomer.getId() > 0) {
				response = ResponseEntity.status(HttpStatus.CREATED)
						.body("Givern user details are registered successfully");

			}
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("An exception occured due to: "+e.getMessage());
		}
		return response;
	}
}
