package com.bookingdetails.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class userNameAlreadyExists extends RuntimeException {

	public userNameAlreadyExists(String exception){
        super(exception);
    }
	
}