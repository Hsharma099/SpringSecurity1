package com.example.bank_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {
	
	@GetMapping("/mycard")
	public String getCardDetails() {
		return "Here is the card details from DB";
	}

}
