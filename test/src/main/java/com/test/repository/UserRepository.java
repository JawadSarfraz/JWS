package com.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.entities.User;

public interface UserRepository extends CrudRepository<User,Integer> {

	User getUserByEmail(String email);

}
