package com.kmk.blogapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kmk.blogapi.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
