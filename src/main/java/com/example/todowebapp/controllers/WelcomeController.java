package com.example.todowebapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {
		
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping(value = "/")
	public String login(ModelMap model) {
		model.put("name", getLoggedInUser());
		return "Welcome";
	}
	
	public String getLoggedInUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info(auth.getName());
		return auth.getName();
	}
}
