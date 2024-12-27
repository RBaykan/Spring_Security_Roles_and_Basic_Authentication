package com.spring.web.configuration;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration

public class SecurityConfiguration{
 
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		
		http.csrf(c -> {
			c.disable();
			
		});
				
		http.authorizeHttpRequests(auth ->  {
			
			auth.requestMatchers(HttpMethod.POST, "/api/user").permitAll();
			auth.requestMatchers(HttpMethod.GET, "/api/user").hasRole("USER");
			auth.requestMatchers("/api/user/registrationConfirm").hasRole("USER");
			// other api and role or authenticated
			auth.anyRequest().permitAll();
			
		});
		
		http.httpBasic(basic -> {});
	
		
		return http.build();
	}

	@Bean
	public PasswordEncoder encoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {

		UserDetails admin = User.builder()
				.username("spring")
				.password(encoder().encode("1234"))
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(admin);

	}
	

	


	

}
