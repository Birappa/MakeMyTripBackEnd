package com.makemytrip.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotExistException extends RuntimeException {

	public UserNotExistException(String errorMessage) {
		super(errorMessage);
	}
}
