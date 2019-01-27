package com.makemytrip.server.services;

import com.makemytrip.server.model.LoginUser;
import com.makemytrip.server.model.User;

public interface UserService {

	public User getUserByEmail(String email)throws Exception;
	public User saveUser(User user)throws Exception;
	public String validateLoginUser(LoginUser loginUser)throws Exception;
	
}
