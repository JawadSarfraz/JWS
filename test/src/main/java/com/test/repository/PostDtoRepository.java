package com.test.repository;



import org.springframework.data.repository.CrudRepository;

import com.test.dto.PostDto;

public interface PostDtoRepository extends CrudRepository<PostDto,Integer> {

}
