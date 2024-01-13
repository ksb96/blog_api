package com.kmk.blogapi.services;

import java.util.List;

import com.kmk.blogapi.payloads.CategoryDto;
import com.kmk.blogapi.payloads.CategoryResponse;
import com.kmk.blogapi.payloads.UserDto;
import com.kmk.blogapi.payloads.UserResponse;

public interface UserService {
	
	//register user
	UserDto registerNewUser(UserDto user);
	
	//userDto-data transfer(var), (a bean class-type)
	//api declaration-bean
	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();
	UserResponse getAllUsser(Integer pageNumber, Integer pageSize);

	void deleteUser(Integer userId);

	UserResponse getAllUsers(Integer pageNumber, Integer pageSize);
}
