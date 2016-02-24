package com.coe.app;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableGlobalMethodSecurity(prePostEnabled=true)
@RestController
public class AuthServerApp {
	
	@RequestMapping("/test")
	public String test(){
		return "Test Method";
	}
	
	@RequestMapping("/")
	String uid(HttpSession session) {
		UUID uid = (UUID) session.getAttribute("uid");
		if (uid == null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		return uid.toString();
	}

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "auth-server");
		SpringApplication.run(AuthServerApp.class, args);
	}
	
	
}
