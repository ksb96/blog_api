package com.kmk.blogapi.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.kmk.blogapi.entities.Category;
import com.kmk.blogapi.entities.Comment;
import com.kmk.blogapi.entities.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
	
	private String imageName;
	
//	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private Set<CommentDto> comments = new HashSet<>(); 
}
