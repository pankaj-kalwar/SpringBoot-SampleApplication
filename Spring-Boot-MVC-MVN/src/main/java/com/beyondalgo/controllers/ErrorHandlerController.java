package com.beyondalgo.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Reference - http://stackoverflow.com/questions/25356781/spring-boot-remove-whitelabel-error-page
 * 
 * */

@RestController
public class ErrorHandlerController implements ErrorController {

	private final String PATH = "/error";

	@RequestMapping(value = PATH)
	public String error() {
		return "Error handling Test";
	}

	public String getErrorPath() {
		return PATH;
	}

}
