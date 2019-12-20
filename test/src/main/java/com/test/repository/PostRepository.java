package com.test.repository;


import org.springframework.data.repository.CrudRepository;

import com.test.entities.Post;

public interface PostRepository extends CrudRepository<Post,Integer> {

}
