package com.kmk.blogapi.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenHelper {
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	private String secret = "jwtTokenKey";
	
	//retrieve username from jwt token
	public String getUsernameFromToken(String token) {
		return getUsernameFromToken(token, Claims::getSubject);
	}
}
