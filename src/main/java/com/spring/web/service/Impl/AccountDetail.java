package com.spring.web.service.Impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.web.model.User;

import lombok.Data;

@Data
public class AccountDetail implements UserDetails {

	private String username;
	private String password;
	private List<GrantedAuthority> roles;
	
	public AccountDetail(User user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.roles=user.getRoles().stream().map((role ->
				new SimpleGrantedAuthority("ROLE_" + role.getRole()))).collect(Collectors.toList());
		
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return roles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	
	

}
