package com.kmk.blogapi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kmk.blogapi.entities.Category;
import com.kmk.blogapi.entities.Post;
import com.kmk.blogapi.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
//	@Query("select p from Post p where p.title like: key")
	List<Post> findByTitleContaining(String title);
}
