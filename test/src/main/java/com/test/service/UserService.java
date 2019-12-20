package com.test.service;



import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.service.UserService;
import com.test.entities.User;
import com.test.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	// save User
	public User saveUser(User user) {
		return (User) this.userRepository.save(user);
	}

	// find All Users
	public List<User> findAll() {
		return (List<User>) this.userRepository.findAll();
	}

	// get user by id
	public Optional<User> getOne(int id) {
		return this.userRepository.findById(id);
	}

	// delete user/ or maybe Boolean type
	public void delete(User user) {
		this.userRepository.delete(user);
	}

	// get User by email
	public User getUserByEmail(String email) {
		logger.info("getUserByEmail() starts");
		if (email.isEmpty()) {
			logger.info("getUserByEmail() ends");
			return null;
		}
		logger.info("getUserByEmail() ends");
		return this.userRepository.getUserByEmail(email);
	}

	// Return Null if userNotExist or Pass Wrong
	public User getUserByEmailAndPassword(String email, String password) {
		User user = getUserByEmail(email);
		if (user == null) {
			return null;
		} else {
			if (user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}


}
