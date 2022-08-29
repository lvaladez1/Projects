package com.AppNowFinal.auth;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AppNowFinal.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	Post findByUserID(Long userID);
	Post findByTitle(String title);
	Post findByBody(String body);
	
	List<Post> findAllByUserID(Long userID);
	List<Post> findByTitleContainingIgnoreCase(String title);
	List<Post> findByBodyContainingIgnoreCase(String body);
}