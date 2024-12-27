package com.spring.web.configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.spring.web.service.Impl.AccountDetailService;

@Component
public class AccountProvider implements AuthenticationProvider{

	private final AccountDetailService service;
	private final PasswordEncoder encoder;
	
	public AccountProvider(AccountDetailService service, PasswordEncoder encoder) {
		this.service = service;
		this.encoder = encoder;
	}
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		var username = authentication.getName();
		var password = (String) authentication.getCredentials();
		try {
			
			UserDetails details = service.loadUserByUsername(username);
			
			if(!encoder.matches(password, details.getPassword())) {
				
				throw new BadCredentialsException("Bad credentials");
			}
			
			return new UsernamePasswordAuthenticationToken(details, password, details.getAuthorities() );
			
		}catch(AuthenticationException e) {
			
			throw  new AuthenticationException("Account not found") {};
			
		}
	
	}
	
	

	
	

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));

	}

}
