package com.kmk.blogapi.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Override
	//this will get call whenever an api request will get hit
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//get token
		String requestToken = request.getHeader("Authorization");
		
		//bearer 2343434erdfdf4
		System.out.println(requestToken);
		
		String username = null;
		String token = null;
		
		if(request!=null && requestToken.startsWith("Bearer")) {
			
			
		}else {
			System.out.println("Jwt token doesn't starts with Bearer");
		}
	}

}
