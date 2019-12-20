package com.test.repository;


import org.springframework.data.repository.CrudRepository;

import com.test.entities.Comment;

public interface CommentRepository extends CrudRepository<Comment,Integer> {

}
