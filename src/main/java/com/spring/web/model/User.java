package com.spring.web.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name="Account")
public class User {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "account_id") 
	private Long id; 
	
	private String firstname;
	private String lastname;
	@Column(unique = true) private String username;
	private String password;
	@Column(unique = true) private String email;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private List<Token> tokens;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "account_role",
			joinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "account_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")}
			)
	private List<Role> roles;
	
	
	
	private boolean enabled;
	
	
	
	
	
	public User() {
		this.enabled = false;
	}
	
}
