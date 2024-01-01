package com.kmk.blogapi.exceptions;

public class ApiException extends RuntimeException{

	public ApiException(String message) {
		super(message);
		
	}

	public ApiException() {
		super();
		
	}
	
}
