package com.in28minutes.rest.webservices.restfulwebservices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebservices.helloworld.HelloWorldBean;

@RestController
public class HelloWorldController {
	@Autowired
	private MessageSource message;

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Welcome to Microservices";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello-Wold-Bean");
	}

	@GetMapping(path = "/hello-world-pathVariable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello-Wold-Bean, %s", name));
	}

	@GetMapping("/hello-world-internationalized")
	public String helloWorldInternationalized()
	//		@RequestHeader(name = "Accept-Language", required = false) Locale locale) 
	{

		return message.getMessage("good.moring.message", null, "Default Mesage", 
				//locale);
				LocaleContextHolder.getLocale());
		// return "Welcome to Microservices";
	}

}
