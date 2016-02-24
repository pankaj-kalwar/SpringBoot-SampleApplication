package com.beyondalgo.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@RequestMapping(value="/user")
	public String testUser(){
		System.out.println("\n\n=== Inside User controller method ====");
		return "Welcome to User Service";
	}
}
