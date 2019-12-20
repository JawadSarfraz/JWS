package com.test.service;



import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entities.Post;
import com.test.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	private static final Logger logger = LoggerFactory.getLogger(PostService.class);

	// save Post
	public Post savePost(Post post) {
		return (Post) this.postRepository.save(post);
	}

	// find All Users
	public List<Post> findAll() {
		return (List<Post>) this.postRepository.findAll();
	}

	// get user by id
	public Optional<Post> getOne(int id) {
		return this.postRepository.findById(id);
	}

	// delete user/ or maybe Boolean type
	public void delete(Post post) {
		this.postRepository.delete(post);
	}
}
