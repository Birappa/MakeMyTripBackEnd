package com.makemytrip.server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.makemytrip.server.model.User;
import com.makemytrip.server.services.LoginRegistrationService;

@RestController
@RequestMapping("/makemytrip")
//@CrossOrigin("http://localhost:4200")
public class LoginRegistrationController {

	
	@Autowired
	private LoginRegistrationService loginRegistrationService;
	
	@GetMapping("/users")
	public Object getAllUsers(){
		return loginRegistrationService.getAllUsers();
	}
	
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable long id) {
		return loginRegistrationService.getUser(id);
	}
	
	
	@PostMapping("/users")
	public String addUser(@RequestBody User user) {
		loginRegistrationService.addUser(user);
		return "user successfully added";
	}
	
	
	@PutMapping("/users/{id}")
	public void updateUser(@PathVariable long id,@RequestBody User user) {
		loginRegistrationService.updateUser(id,user);
	}
	
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable long id) {
		loginRegistrationService.deleteUser(id);
		return "user has deleted";
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	 
	/*@PostMapping("/login")
	    public String loginUserValidate(@RequestBody User logUser)
	    {
		 return loginRegistrationService.loginUserValidate(logUser);
	    }
	
	
	@PostMapping("/users/changepass/email")
	 public void changePassword(@PathVariable String email,@PathVariable String password)
	 {
		
		 loginRegistrationService.changeOldPassword(email, password);
		 
	 }*/
	
}
