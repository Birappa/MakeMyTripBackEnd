package com.makemytrip.server.repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.makemytrip.server.model.User;


public interface LoginRegistrationRepository extends MongoRepository<User, String> {

	

}
