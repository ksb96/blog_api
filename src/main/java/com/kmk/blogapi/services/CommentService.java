package com.kmk.blogapi.services;

import com.kmk.blogapi.payloads.CommentDto;

public interface CommentService {
	
	//CREATE comment - POST
	CommentDto createComment(CommentDto commentDto, Integer postId);
	
	//DELETE comment
	void deleteComment(Integer commentId);
}
