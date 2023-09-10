package com.kmk.blogapi.services.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmk.blogapi.entities.Category;
import com.kmk.blogapi.entities.Post;
import com.kmk.blogapi.entities.User;
import com.kmk.blogapi.exceptions.ResourceNotFoundException;
import com.kmk.blogapi.payloads.PostDto;
import com.kmk.blogapi.repo.CategoryRepo;
import com.kmk.blogapi.repo.PostRepo;
import com.kmk.blogapi.repo.UserRepo;
import com.kmk.blogapi.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private CategoryRepo categoryRepo;

//	POST
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
//		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);

		// save post
		Post newPost = this.postRepo.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public Post updatePost(PostDto postDto, Integer postId) {

		return null;
	}

	@Override
	public void deletePost(Integer postId) {

	}

	@Override
	public List<Post> getAllPost() {

		return null;
	}

	@Override
	public Post getPostById(Integer postId) {

		return null;
	}

	@Override
	public List<Post> getPostsByCategory(Integer categoryId) {

		return null;
	}

	@Override
	public List<Post> getPostsByUser(Integer userId) {

		return null;
	}

	@Override
	public List<Post> searchPosts(String keyword) {

		return null;
	}

}
