package com.makemytrip.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.makemytrip.server.exception.AlreadyUserExistException;
import com.makemytrip.server.exception.BadRequestException;
import com.makemytrip.server.exception.UserNotExistException;
import com.makemytrip.server.model.ApiResponse;
import com.makemytrip.server.model.LoginUser;
import com.makemytrip.server.model.User;
import com.makemytrip.server.services.UserService;

@RestController
@RequestMapping("/makemytrip")
@CrossOrigin("*")
public class LoginRegistrationController {


	@Autowired
	private UserService userService;

	@GetMapping("/users/{email}")
	public ApiResponse<User> getUserByEmail(@PathVariable String email) {
		
		try {
			return new ApiResponse<User>(HttpStatus.OK.value(), "User details", userService.getUserByEmail(email));
		}catch(Exception e) {
			
			throw new UserNotExistException("Invalid Email Address");
		}
		
	}

	@PostMapping("/users")
	public ApiResponse<User> saveUser(@RequestBody User user) {
		
		try {
			return new ApiResponse<>(HttpStatus.OK.value(), "User Registered successfully.",userService.saveUser(user));
		}catch (Exception e) {
			
			throw new AlreadyUserExistException("Already User Exist");
		}
		
	}
	
	@PostMapping("/users/login")
	public ApiResponse<String> validateLoginUser(@RequestBody LoginUser loginUser) {
		
		try {
			String userName = userService.validateLoginUser(loginUser);
			if(userName==null)
				throw new BadRequestException("Invalid username or password");
			return new ApiResponse<>(HttpStatus.OK.value(),"User logged successfully",userName);
		}catch (Exception e) {
			
			throw new BadRequestException("Invalid username or password");
		}
			
	}
	

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		
		return new RestTemplate();
	}


}
