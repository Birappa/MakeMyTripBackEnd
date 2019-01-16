package com.makemytrip.server.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.makemytrip.server.model.User;
import com.makemytrip.server.repository.LoginRegistrationRepository;

@Service
public class LoginRegistrationService {

	@Autowired
	private LoginRegistrationRepository loginRegistrationRepository;
	
	public List<User> getAllUsers() {
	
		return loginRegistrationRepository.findAll();
		
	}

	public User getUser(String id) {
		
		return loginRegistrationRepository.findById(id).get();
	}

	public User addUser(User user) {
		return loginRegistrationRepository.save(user);
	}

	public User updateUser(String id, User user) {

		return loginRegistrationRepository.save(user);
		
	}

	public void deleteUser(String id) {
		
		loginRegistrationRepository.deleteById(id);
	}
	
	public String loginUserValidate(User loginUser) {
		List<User> log = loginRegistrationRepository.findAll();
		for (User list1 : log) {

			if (loginUser.getName().equals(list1.getName()) && loginUser.getPassword().equals(list1.getPassword())) {
				return "valid User";
			}
		}
		return "Password and UserId did not match";
	}

}
