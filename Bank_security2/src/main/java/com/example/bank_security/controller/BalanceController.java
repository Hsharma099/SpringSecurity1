package com.example.bank_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
	
	@GetMapping("/mybalance")
	public String getBalanceDetails() {
		return "Here is the Balance details from DB";
	}
	

}
