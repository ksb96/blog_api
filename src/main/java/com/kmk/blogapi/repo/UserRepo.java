package com.kmk.blogapi.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kmk.blogapi.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	Optional<User> findByEmail(String email);
}
