package com.kmk.blogapi.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmk.blogapi.entities.Comment;
import com.kmk.blogapi.entities.Post;
import com.kmk.blogapi.exceptions.ResourceNotFoundException;
import com.kmk.blogapi.payloads.CommentDto;
import com.kmk.blogapi.repo.CommentRepo;
import com.kmk.blogapi.repo.PostRepo;
import com.kmk.blogapi.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private ModelMapper modelmapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Post id", postId));
		Comment comment = this.modelmapper.map(commentDto, Comment.class); // comment created & mapped

		comment.setPost(post);// assigning 'comment' value to the 'post'
		Comment savedComment = this.commentRepo.save(comment); // saved comment

		return this.modelmapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment com = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "Comment id", commentId));
		this.commentRepo.delete(com);
	}

}
