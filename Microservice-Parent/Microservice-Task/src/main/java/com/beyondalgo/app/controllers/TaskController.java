package com.beyondalgo.app.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	
	@RequestMapping(value="/task")
	public String testTask(){
		System.out.println("Task Service - Task Controller Hit");
		return "Welcome to Task Service";
	}
}
