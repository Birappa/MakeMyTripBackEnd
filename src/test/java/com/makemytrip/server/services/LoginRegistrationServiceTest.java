package com.makemytrip.server.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.makemytrip.server.model.User;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoginRegistrationServiceTest {
	
	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	private LoginRegistrationService userService;
	
	private final String uri="http://user-data-service/users";
	
	@Before
	private void setup() {
		MockitoAnnotations.initMocks(this);

	}
	
	@Test
	public void testSaveUser() throws Exception {
		User user=new User(1,"birappa","birappa@gmail.com","admin");
		
		when(restTemplate.postForObject(uri,user,User.class)).thenReturn(user);
		
		User result=userService.saveUser(user);
		
		assertEquals(1, result.getId());
		assertEquals("birappa", result.getUserName());
		assertEquals("birappa@gmail.com", result.getEmail());
		
	}
	
	@Test
	public void testGetUserByEmail() throws Exception{
		
		User user=new User(1,"birappa","birappa@gmail.com","admin");

		when(restTemplate.getForObject(uri+"/{email}",User.class,"birappa@gmail.com")).thenReturn(user);

		User result=userService.getUserByEmail("birappa@gmail.com");

		assertEquals(1, result.getId());
		assertEquals("birappa", result.getUserName());
		assertEquals("birappa@gmail.com", result.getEmail());
	}
		
}
