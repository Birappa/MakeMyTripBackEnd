package com.makemytrip.server.services;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.makemytrip.server.model.User;
import com.makemytrip.server.repository.LoginRegistrationRepository;



@Service
public class LoginRegistrationService {

	/*@Autowired
	private LoginRegistrationRepository loginRegistrationRepository;*/
	
	@Inject
	private RestTemplate restTemplate;

	public Object getAllUsers() {

		 return restTemplate.getForEntity("http://user-data-service/users", List.class).getBody();
		//return loginRegistrationRepository.findAll();

	}

	public User getUser(long id) {

		return restTemplate.getForEntity("http://user-data-service/users/"+id, User.class).getBody();
		//return loginRegistrationRepository.findById(id).get();
		//return new User("1","birappa","br@gmail.com",123456,"123456");
	}

	public User addUser(User user) {
		return restTemplate.getForEntity("http://user-data-service/users/", User.class).getBody();
		//return loginRegistrationRepository.save(user);
	}

	public User updateUser(long id, User user) {
		
		return restTemplate.getForEntity("http://user-data-service/users/"+id, User.class,user).getBody();
		//user.setId(id);
		//return loginRegistrationRepository.save(user);

	}

	
	  public void deleteUser(long id) {
		restTemplate.getForEntity("http://user-data-service/users/"+id, User.class).getBody();
		  //loginRegistrationRepository.deleteById(id); 
	 
	  }
	  
	
	  /*public String loginUserValidate(User loginUser) {
		  
				List<User> reges = loginRegistrationRepository.findAll();
				for (User list1 : reges) {

					if ((loginUser.getEmail().equals(list1.getEmail())) && (loginUser.getPassword().equals(list1.getPassword())))  {
						return "valid User";
					}
				}
				return "Invalid Password and userId";
			}

		  	
	  public void changeOldPassword(String email,String password)
	  {
		  List<User> user = loginRegistrationRepository.findAll();
			for (User list2 : user) 
			{
			if(email.matches(email)) 
			{
				
				list2.setPassword(password);
				
			}
			}
      }*/
}