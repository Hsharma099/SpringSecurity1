package com.example.bank_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@GetMapping("/myaccount")
	public String getAccountDetails() {
		return "Here is the acoount details from DB";
	}

}
