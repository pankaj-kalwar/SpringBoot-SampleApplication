package com.beyondalgo.controllers;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	/*@RequestMapping("/hello")
	public String sayHello() {
		return "Hello World !";
	}*/

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView hello() {
		return new ModelAndView("hello").addObject("name", "Pankaj");
	}
	
	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}

	@RequestMapping("/foo")
	public String foo(Map<String, Object> model) {
		throw new RuntimeException("Foo");
	}
}
