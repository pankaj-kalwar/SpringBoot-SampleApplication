package com.coe.app.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	
	@RequestMapping("/auth")
	public Principal user(Principal user){
		System.out.println("\n\n===============\n");
		System.out.println(user);
		System.out.println("\n=================\n\n");
		return user;
	}
	
	
}
