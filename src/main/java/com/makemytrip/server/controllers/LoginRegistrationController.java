package com.makemytrip.server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.makemytrip.server.model.User;
import com.makemytrip.server.services.LoginRegistrationService;

@RestController
@RequestMapping("/makemytrip")
public class LoginRegistrationController {

	
	@Autowired
	private LoginRegistrationService loginRegistrationService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return loginRegistrationService.getAllUsers();
	}
	
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable String id) {
		return loginRegistrationService.getUser(id);
	}
	
	
	@PostMapping("/users")
	public String addUser(@RequestBody User user) {
		loginRegistrationService.addUser(user);
		return "user successfully added";
	}
	
	
	@PutMapping("/users/{id}")
	public void updateUser(@PathVariable String id,@RequestBody User user) {
		loginRegistrationService.updateUser(id,user);
	}
	
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable String id) {
		loginRegistrationService.deleteUser(id);
		return "user has deleted";
	}
	
	 
	@PostMapping("/login")
	    public String loginUserValidate(@RequestBody User logUser)
	    {
		 return loginRegistrationService.loginUserValidate(logUser);
	    }
	
	
	@PostMapping("/users/changepass/email")
	 public void changePassword(@PathVariable String email,@PathVariable String password)
	 {
		
		 loginRegistrationService.changeOldPassword(email, password);
		 
	 }
	
}
