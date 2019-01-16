package com.makemytrip.server.controllers;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.makemytrip.server.model.User;
import com.makemytrip.server.services.LoginRegistrationService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = LoginRegistrationController.class)
public class LoginRegistrationControllerTest {

	private MockMvc mockMvc;
	
	/*@Autowired
    private WebApplicationContext wac;*/
	
	@Mock
	private LoginRegistrationService loginRegistrationService;
	
	/*@Mock
	private User user;*/
	
	
	@InjectMocks
	private LoginRegistrationController loginRegistrationController;
	
	@Before
	public void setUp() throws Exception{
		mockMvc=MockMvcBuilders.standaloneSetup(loginRegistrationController).build();
	}
	
	@Test
	public void testGetAllUsers() throws Exception{
	
		List<User> users=new ArrayList<User>(Arrays.asList(new User("1","birappa","br@gmail.com",123456,"123456"),
				new User("2","prathyusha","pr@gmail.com",123456,"123456"),
				new User("3","sneha","sn@gmail.com",123456,"123456")));
		
		when(loginRegistrationService.getAllUsers()).thenReturn(users);
		
		mockMvc.perform(get("/Users").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		
		verify(loginRegistrationService).getAllUsers();
	}
	
	/*@Test
	public void verifyToDoById() throws Exception {
		User user=new User("1","birappa","br@gmail.com",123456,"123456");
		when(loginRegistrationService.getUser(Mockito.anyString())).thenReturn(user);
		
		mockMvc.perform(get("/Users/1").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(print());
		
		verify(loginRegistrationService).getUser(id)
	}*/
}
