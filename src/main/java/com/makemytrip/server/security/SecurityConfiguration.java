package com.makemytrip.server.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	 @Override 
	 protected void configure(HttpSecurity httpSecurity) throws Exception {
	 
	 httpSecurity 
	 .authorizeRequests() 
	 .anyRequest() 
	 .permitAll()
	 .and()
	 .httpBasic();
	 httpSecurity.csrf().disable(); }
	 
	

}
