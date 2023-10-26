package com.kmk.blogapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kmk.blogapi.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
