package com.kmk.blogapi.services;

import java.util.List;

import com.kmk.blogapi.payloads.UserDto;

public interface UserService {
	
	//userDto-data transfer(var), (a bean class-type)
	//api declaration-bean
	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userId);
}
