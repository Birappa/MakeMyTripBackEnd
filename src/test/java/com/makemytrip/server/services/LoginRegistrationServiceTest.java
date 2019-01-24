package com.makemytrip.server.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.makemytrip.server.model.User;
import com.makemytrip.server.repository.LoginRegistrationRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class LoginRegistrationServiceTest {
	
	@Mock
	private LoginRegistrationRepository loginRegistrationRepository;
	
	@InjectMocks
	private LoginRegistrationService loginRegistrationService;
	
	private void setup() {
		MockitoAnnotations.initMocks(this);

	}
	/*
	@Test
	public void testGetAllUsers() throws Exception {
		List<User> users=new ArrayList<User>(Arrays.asList(new User("1","birappa","br@gmail.com",123456,"123456"),
				new User("2","prathyusha","pr@gmail.com",123456,"123456"),
				new User("3","sneha","sn@gmail.com",123456,"123456")));
		
		when(loginRegistrationRepository.findAll()).thenReturn(users);
		
		Object result=loginRegistrationService.getAllUsers();
		
		//assertEquals(3, result.size());
		
	}
	
	
	@Test
	public void testGetUser() throws Exception {
		User user=new User("3","sneha","sn@gmail.com",123456,"123456");
		
		when(loginRegistrationRepository.findById(Mockito.anyString())).thenReturn(Optional.of(user));
		
		User result=loginRegistrationService.getUser(3);
		
		assertEquals("3", result.getId());
		assertEquals("sneha", result.getName());
		assertEquals("sn@gmail.com", result.getEmail());
		
	}
	
	
	@Test
	public void testAddUser() throws Exception {
		User user=new User("3","sneha","sn@gmail.com",123456,"123456");
		
		when(loginRegistrationRepository.save(user)).thenReturn(user);
		
		User result=loginRegistrationService.addUser(user);
		
		assertEquals("3", result.getId());
		assertEquals("sneha", result.getName());
		assertEquals("sn@gmail.com", result.getEmail());
		
	}

	
	@Test
	public void testDeleteUser() throws Exception {
		User user=new User("3","sneha","sn@gmail.com",123456,"123456");
		
		loginRegistrationService.deleteUser(3);
		
		verify(loginRegistrationRepository, times(1)).deleteById("3");
		
	}*/
	
}
