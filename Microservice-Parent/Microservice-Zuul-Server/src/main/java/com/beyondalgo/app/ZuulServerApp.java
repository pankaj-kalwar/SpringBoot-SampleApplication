package com.beyondalgo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulServerApp {
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "zuul-server");
		SpringApplication.run(ZuulServerApp.class, args);
	}
}
