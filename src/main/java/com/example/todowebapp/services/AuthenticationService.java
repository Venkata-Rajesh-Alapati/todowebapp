package com.example.todowebapp.services;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username, String password) {
		boolean validUser = username.equalsIgnoreCase("Venkata");
		boolean validPassword = password.equalsIgnoreCase("Venkata");
		return validUser && validPassword;
	}
}
