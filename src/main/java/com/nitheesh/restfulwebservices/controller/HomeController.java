package com.nitheesh.restfulwebservices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	

	@Autowired
   private MessageSource messageSource;
	
	
	@GetMapping(path = "/hellow-world")
	public String printhello() {
		return "hellow-world";
	}
	
	
	@GetMapping("/hello-world-inter")
	public String internationalization() {
		
		
		Locale locale =LocaleContextHolder.getLocale();
		return messageSource.getMessage("goodmorning.message", null,"Default Message", locale );
		
	}
	

}
