package com.kmk.blogapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kmk.blogapi.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer>{

}
