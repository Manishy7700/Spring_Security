package com.security.manish.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("security")
public class RequestController {

	
	@GetMapping("/home")
	public String home() {
		return "Welcome to home page...";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact no.-9029928345";
	}
	@GetMapping("/info")
	public String info() {
		return "only admin permision";
	}
}
