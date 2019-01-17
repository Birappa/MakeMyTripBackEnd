package com.makemytrip.server.security;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



//@EnableConfigurationProperties
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	/*
	 * @Autowired RegisterService regService;
	 */
	
	 @Override 
	 protected void configure(HttpSecurity httpSecurity) throws Exception {
	 
	 httpSecurity 
	 .authorizeRequests() 
	 .anyRequest() 
	 .permitAll()
	 .and()
	 .httpBasic();
	 httpSecurity.csrf().disable(); }
	 
	
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { http
	 * .csrf().disable() .authorizeRequests().anyRequest().authenticated()
	 * .and().httpBasic() .and().sessionManagement().disable(); }
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder();
	 * 
	 * }
	 * 
	 * @Override public void configure(AuthenticationManagerBuilder builder) throws
	 * Exception { builder.userDetailsService(userDetailsService()); }
	 */
}
