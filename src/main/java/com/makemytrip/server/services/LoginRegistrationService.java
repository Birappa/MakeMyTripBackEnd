package com.makemytrip.server.services;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.makemytrip.server.model.LoginUser;
import com.makemytrip.server.model.User;


@Service
public class LoginRegistrationService implements UserService {


	private final String uri="http://user-data-service/users";

	@Inject
	private RestTemplate restTemplate;

	public User getUserByEmail(String email) throws Exception {

		return restTemplate.getForObject(uri+"/{email}", User.class,email);

	}

	public User saveUser(User user) throws Exception {

		return restTemplate.postForObject(uri, user, User.class);

	}

	public String validateLoginUser(LoginUser loginUser) throws Exception{
		User user = getUserByEmail(loginUser.getEmail());
		if(user.getPassword().equals(loginUser.getPassword()))
			return user.getUserName();
		return null;
	}
}