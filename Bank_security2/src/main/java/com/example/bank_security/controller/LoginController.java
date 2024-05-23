package com.example.bank_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank_security.model.Customer;
import com.example.bank_security.repository.CustomerRepository;

@RestController
public class LoginController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*
	 * This method is registring new user
	 */

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer){
		
		Customer savedCustomer = null;
		ResponseEntity response = null;
		try {
			/*"$2a$10$IvxH6XNEXfl3f9E/pDFtf.EjGsLBiE3cUkJljsNkD/p3GrZU3xm5e
			 *$2a: This indicates the bcrypt algorithm version. 
			 *In this case, "2a" refers to the version of the bcrypt algorithm used. There are different versions of bcrypt (like $2a, $2b, $2y, etc.),
			 * and $2a is a common version used. 
			 * $10:This represents the cost factor, also known as the log rounds. 
			 * It defines the computational complexity of the hashing process.
			 */
			String hashPassword = passwordEncoder.encode(customer.getPwd());
			customer.setPwd(hashPassword);
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
