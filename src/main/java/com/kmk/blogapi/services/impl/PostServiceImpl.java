package com.kmk.blogapi.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
	//user -categoryID, taking out categoryID from db
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Post/s", "category id", categoryId));
		//posts related to category selected(categoryID)
		List<Post> posts = this.postRepo.findByCategory(cat);

		//converting all(post-one-by-one) posts to postDto & return
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Post/s", "user id", userId));
		//posts related to user selected(userID)
		List<Post> userPosts = this.postRepo.findByUser(user);

		//converting all(post-one-by-one) posts to postDto & return
		List<PostDto> postDtos = userPosts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postDtos;
	} 

	@Override
	public List<Post> searchPosts(String keyword) {

		return null;
	}

}
