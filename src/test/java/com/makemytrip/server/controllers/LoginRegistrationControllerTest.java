package com.makemytrip.server.controllers;


import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.RequestResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.makemytrip.server.MakeMyTripBackEndApplication;
import com.makemytrip.server.model.User;
import com.makemytrip.server.services.LoginRegistrationService;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = MakeMyTripBackEndApplication.class)
@SpringBootTest
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@WebMvcTest(value = LoginRegistrationController.class)
public class LoginRegistrationControllerTest {

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;
	
	@Mock
	private LoginRegistrationService loginRegistrationService;
	
	/*@Mock
	private User user;*/
	
	
	@InjectMocks
	private LoginRegistrationController loginRegistrationController;
	
	@Before
	public void setUp() throws Exception{
		//mockMvc=MockMvcBuilders.standaloneSetup(loginRegistrationController).build();
		//MockitoAnnotations.initMocks(this);
		 this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	/*@Test
	public void testgetUserMethod() throws Exception{
		mockMvc.perform(get("/userobj").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}*/
	
	/*@Test
	public void verifyAllUserList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(5))).andDo(print());
	}
	
	
	@Test
	public void verifyGetUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/users/5c3ef5404dc4c41e54c7c263").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.name").exists())
		.andExpect(jsonPath("$.email").exists())
		.andExpect(jsonPath("$.contact").exists())
		.andExpect(jsonPath("$.password").exists())
		.andExpect(jsonPath("$.id").value("5c3ef5404dc4c41e54c7c263"))
		.andExpect(jsonPath("$.name").value("birappa"))
		.andExpect(jsonPath("$.email").value("bir@gmail.com"))
		.andDo(print());
	}
	
	
	@Test
	public void verifyDeleteUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/users/5c3f1fd84dc4c41fcce3084f").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").value("User is removed successfully"))
		.andDo(print());
	}
	
	
	@Test
	public void verifyAddUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/users/")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\" : \"sneha\", \"email\" : \"sneha@gmail.com\",\"contact\" : \"123456\",\"password\" : \"sneha\" }"))
		.andExpect(jsonPath("$").value("User successfully added"))
		.andDo(print());
	}
	
	
	@Test
	public void verifyUpdateUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/users/5c3ef6ea4dc4c4296477f503")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\" : \"swati\", \"email\" : \"swati@gmail.com\",\"contact\" : \"123456\",\"password\" : \"swati\" }"))
		.andExpect(jsonPath("$").value("User successfully updated"))
		.andDo(print());
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	@Test
	public void testGetAllUsers() throws Exception{
	
		List<User> users=new ArrayList<User>(Arrays.asList(new User("1","birappa","br@gmail.com",123456,"123456"),
				new User("2","prathyusha","pr@gmail.com",123456,"123456"),
				new User("3","sneha","sn@gmail.com",123456,"123456")));
		
		when(loginRegistrationService.getAllUsers()).thenReturn(users);
		
		mockMvc.perform(get("/users").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andDo(print());
		
		//verify(loginRegistrationService).getAllUsers();
	}
	
	@Test
	public void testGetUser() throws Exception {
		User user=new User("2","birappa","br@gmail.com",123456,"123456");
		
		when(loginRegistrationService.getUser(Mockito.anyLong()));
		
		mockMvc.perform(get("/users/5c4156904dc4c40c04a261fb"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value("5c4156904dc4c40c04a261fb"))
		.andDo(print());
		
		//verify(loginRegistrationService).getUser("1");
	}
	
	
	@Test
	public void testDeleteUser() throws Exception {
		User user=new User("1","birappa","br@gmail.com",123456,"123456");
		
		//when(loginRegistrationService.deleteUser(Mockito.anyString())).thenReturn("user has deleted");
		
		 mockMvc.perform(delete("/users/1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").value("user has deleted"))
		.andDo(print());
		
		//verify(loginRegistrationService).getUser("1");
	}
	
	
	@Test
	public void testAddUser() throws Exception {
		
		
		mockMvc.perform(MockMvcRequestBuilders.post("/users/")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\" : \"sneha\", \"email\" : \"sneha@gmail.com\",\"contact\" : \"123456\",\"password\" : \"sneha\" }"))
		.andExpect(jsonPath("$").value("user successfully added"))
		.andDo(print());
	}*/
	
}
