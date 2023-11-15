package com.example.todowebapp.security;

import java.net.http.HttpRequest;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class UserDetailsConfiguration {

	@Bean
	public InMemoryUserDetailsManager getUsers() {
		UserDetails user1 = createUser("Venkata", "Venkata");
		UserDetails user2 = createUser("Rajesh", "Rajesh");
		return new InMemoryUserDetailsManager(user1, user2);
	}

	private UserDetails createUser(String userName, String pass) {
		Function<String, String> passwordEncoder = input -> getPasswordEncoder().encode(input);
		UserDetails user = User.builder().passwordEncoder(passwordEncoder).username(userName).password(pass)
				.roles("USER", "ADMIN").build();
		return user;
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain urlSecurity(HttpSecurity req) throws Exception {
		req.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		req.formLogin(withDefaults());
		req.csrf().disable();
		req.headers().frameOptions().disable();
		return req.build();
	}
}
