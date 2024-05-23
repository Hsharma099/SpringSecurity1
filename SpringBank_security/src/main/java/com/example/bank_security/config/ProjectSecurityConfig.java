package com.example.bank_security.config;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	/**
	 * This method authorize some requests i.e custom security configurations
	 * 
	 * @param http
	 * @return
	 * @throws Exception //
	 */
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests(requests -> {
			requests.requestMatchers("/myaccount", "/mybalance", "/mycard", "/myloan").authenticated()
					.requestMatchers("/contact", "/notices","/register").permitAll();
		}).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	
//	/**
//	 * This method deny all requests
//	 * @param http
//	 * @return
//	 * @throws Exception
//	 */
//	@Bean
//	SecurityFilterChain defaultSecurityFilterChainDenyAll(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(requests -> {
//			requests.anyRequest().denyAll();
//		}).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
//		return http.build();
//	}

	
	
//	/**
//	 * This method permit all requests
//	 * 
//	 * @param http
//	 * @return
//	 * @throws Exception
//	 */
//
//	@Bean
//	SecurityFilterChain defaultSecurityFilterChainPermitAll(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests(requests -> {
//			requests.anyRequest().permitAll();
//		}).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
//		return http.build();
//	}

	
	
	/**
	 * This method create MULTIPLE USERS in memory itself using default
	 * passwordEncoder
	 * 
	 * @return //
	 */
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		
	/*
	 * Approach-1 withdefaultPasswordEncoder() * There are no plans to remove this
	 * support. It is deprecated to indicate that this is considered insecure for
	 * production purposes.
	 */
		
	//here user impl userdetails(Interface)thats why not getting error while typecasting
//		UserDetails admin = User.withDefaultPasswordEncoder().username("admin")
//				.password("12345")
//				.authorities("admin")
//				.build();
//		
//		UserDetails user = User.withDefaultPasswordEncoder().username("user")
//				.password("12345")
//				.authorities("read")
//				.build();
//		
//		  UserDetails user1 = User.withDefaultPasswordEncoder()
//		            .username("user1")
//		            .password("12345")
//		            .authorities("read") // or any other authority you want to grant
//		            .build();
		  
		  //to create n no of users
//		  
//		  List<UserDetails> users = new ArrayList<>();
//
//	        // Create 'n' number of users dynamically
//	        for (int i = 1; i <= 10; i++) {
//	            UserDetails user = User.withDefaultPasswordEncoder()
//	                    .username("user" + i)
//	                    .password("12345")
//	                    .authorities("read") // or any other authority you want to grant
//	                    .build();
//	            users.add(user);
//	        }
		
//		return new InMemoryUserDetailsManager(admin,user,user1);
		
	/*
	 * Approach-II where we create NoOpPassword encoder Bean seperately
	 */
//		UserDetails admin = User.withUsername("admin")
//				.password("abcd")
//				.authorities("admin")
//				.build();
//		
//		UserDetails user = User.withUsername("user")
//				.password("abcd")
//				.authorities("read")
//				.build();
//		return new InMemoryUserDetailsManager(admin,user);
////
//	}

	
	
	/*
	 * This method is used for creating users by using JDBC Users details manager
	 */
//	@Bean
//	public UserDetailsService userDetailsService(DataSource dataSource) {
//		//userdetails ervice is the parent of JDBC user detail manager
//		return new JdbcUserDetailsManager(dataSource);
//	}
	
	
	
	/*
	 * This method returns the NoOpPassword encoder Bean as an Object
	 * Always require password encoder to store password as text or encrpyted form
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}
