package com.beyondalgo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.security.oauth2.resource.EnableOAuth2Resource;
import org.springframework.cloud.security.oauth2.sso.EnableOAuth2Sso;

@SpringBootApplication
@EnableDiscoveryClient
@EnableOAuth2Resource
//@EnableOAuth2Sso
public class TaskServiceApp {
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "task-server");
		SpringApplication.run(TaskServiceApp.class, args);
	}
}
