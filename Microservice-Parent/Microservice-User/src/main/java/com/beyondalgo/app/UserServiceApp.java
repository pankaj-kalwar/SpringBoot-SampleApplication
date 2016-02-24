package com.beyondalgo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApp {
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "user-server");
		SpringApplication.run(UserServiceApp.class, args);
	}
}
