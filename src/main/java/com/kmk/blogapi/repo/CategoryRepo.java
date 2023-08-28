package com.kmk.blogapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kmk.blogapi.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
