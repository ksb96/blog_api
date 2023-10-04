package com.kmk.blogapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kmk.blogapi.exceptions.*;
import com.kmk.blogapi.entities.*;
import com.kmk.blogapi.payloads.CategoryDto;
import com.kmk.blogapi.payloads.CategoryResponse;
import com.kmk.blogapi.payloads.UserDto;
import com.kmk.blogapi.payloads.UserResponse;
import com.kmk.blogapi.repo.*;
import com.kmk.blogapi.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	// CREATE {API}
	public UserDto createUser(UserDto userDto) { // converts 1-obj to-another obj
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	// UPDATE {API}
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// get
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId)); // notfound

		// set
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());

		// update
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);

		return userDto1; // data transfer object convertion
	}

	@Override
	// GET {API} by ID
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		return this.userToDto(user);
	}

	@Override
//	 GET {API} ALL USER
	public UserResponse getAllUsers(Integer pageNumber, Integer pageSize) {

		Pageable p = PageRequest.of(pageNumber, pageSize);
		Page<User> userPage = this.userRepo.findAll(p);

		List<User> users = userPage.getContent();
		List<UserDto> userDtos = userPage.stream().map((user) -> this.modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());

		UserResponse userResponse = new UserResponse();
		userResponse.setContent(userDtos);
		userResponse.setPageNumber(userPage.getNumber());
		userResponse.setPageSize(userPage.getSize());
		userResponse.setTotalRecods(userPage.getTotalElements());
		userResponse.setTotalPages(userPage.getTotalPages());
		userResponse.setLastPage(userPage.isLast());

		return userResponse;
	}

	@Override
	// DELETE {API} BY ID
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		this.userRepo.delete(user);

	}

	// convertion- start
	private User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		return user;
	}

	public UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}
	// convertion- end

	@Override
	public UserResponse getAllUsser(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
