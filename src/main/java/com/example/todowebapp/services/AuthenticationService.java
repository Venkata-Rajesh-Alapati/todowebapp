package com.example.todowebapp.services;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username, String password) {
		boolean validUser = "Venkata".equalsIgnoreCase(username);
		boolean validPassword = "Venkata".equalsIgnoreCase(password);
		return validUser && validPassword;
	}
}
