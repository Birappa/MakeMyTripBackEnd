package com.makemytrip.server.services;

import java.util.List;


import javax.inject.Inject;



import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.makemytrip.server.model.User;




@Service
public class LoginRegistrationService {

	
	private final String uri="http://user-data-service/users";
	
	@Inject
	private RestTemplate restTemplate;

	public List getAllUsers() {

		 return restTemplate.getForEntity(uri, List.class).getBody();

	}

	public User getUserByEmail(String email) {

		return restTemplate.getForObject(uri+"/{email}", User.class,email);
	
	}
	
	public User getUserById(long id) {

		return restTemplate.postForObject(uri+"/{id}",id, User.class,id);
	
	}

	public User addUser(User user) {
		
		return restTemplate.postForObject(uri, user, User.class);
		
	}

	public void updateUser(long id, User user) {
		
		restTemplate.put(uri+"/{id}",user,id);
		
	}

	
	  public void deleteUser(long id) {
		  
		restTemplate.delete(uri+"/{id}", id);
		  
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