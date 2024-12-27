package com.spring.web.service.Impl;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import com.spring.web.exceptions.UserNotFound;
import com.spring.web.model.User;
import com.spring.web.repository.UserRepository;

@Service
public class AccountDetailService implements UserDetailsService{

	private final UserRepository repository;
	private final UserDetailsService details;
	
	public AccountDetailService(UserRepository repository, UserDetailsService details ) {
		
		this.repository = repository;
		this.details = details;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username).orElse(null);
		
		if(user == null) {		
			
			return details.loadUserByUsername(username);
		}
		
		return new AccountDetail(user);
	}

}
