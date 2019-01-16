package com.makemytrip.server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.makemytrip.server.model.User;
import com.makemytrip.server.services.LoginRegistrationService;



@RestController
public class LoginRegistrationController {

	
	@Autowired
	private LoginRegistrationService loginRegistrationService;
	
	@RequestMapping("/users")
	public List<User> getAllUsers(){
		return loginRegistrationService.getAllUsers();
	}
	
	@RequestMapping("/users/{id}")
	public User getUser(@PathVariable String id) {
		return loginRegistrationService.getUser(id);
	}
	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public void addUser(@RequestBody User user) {
		loginRegistrationService.addUser(user);
	}
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.PUT)
	public void updateUser(@PathVariable String id,@RequestBody User user) {
		loginRegistrationService.updateUser(id,user);
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable String id) {
		loginRegistrationService.deleteUser(id);
		return "User is removed successfully";
	}
	
	 @RequestMapping(method=RequestMethod.POST,value="/login")
	    public void loginUserValidate(@RequestBody User logUser)
	    {
		 loginRegistrationService.loginUserValidate(logUser);
	    }
	
	
}
