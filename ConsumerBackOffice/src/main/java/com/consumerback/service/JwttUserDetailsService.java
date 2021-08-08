package com.consumerback.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwttUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		String userString = "faizshiraji";
		String passwordString = "$2a$10$6HXOlKPHIcJ/1eflfeo8XODkQ8Hvoq2TYXSNcb08ZQoOfpZZK4s/y";
		
		if (userString.equals(username)) {
			return new User(userString, passwordString, new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}
