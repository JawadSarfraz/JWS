package com.test.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.entities.User;
import com.test.service.UserService;

@RestController
@RequestMapping("/user")

public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index() {

		// TODO Auto-generated method stub

		//User u1 = new User("asaz", "aas", "qw", 15, "qew", "azz", "zxc", "xsc", 15);

		Optional<User> temp = userService.getOne(15);
		if (temp.isPresent()) {
			System.out.println(temp.get());
		} else {
			System.out.println("No User found");
		}
		System.out.print(temp.getClass().getName());
		return "Meowwwww....";
	}

	@PostMapping("/sign")
	public void createUse() {
		// return Response.build();
		int a =1;
		System.out.print(a);
		//return this.userService.saveUser(user);
	}
	@PostMapping("/signUp")
	public User createUser(@Valid @RequestBody User user) {
		// return Response.build();
		return this.userService.saveUser(user);
	}

	@GetMapping("/findAllUser")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> users = this.userService.findAll();
		if (users == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(users);
	}

	// get one user

	@GetMapping("/findUser/{id}")
	public ResponseEntity<Optional<User>> getUse(@PathVariable(value = "id") int id) {
		Optional<User> user = this.userService.getOne(id);
		if (user == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<User> update(@PathVariable(value = "id") int id, @Valid @RequestBody User user) {
		Optional<User> getUser = this.userService.getOne(id);
		if (getUser == null)
			return ResponseEntity.notFound().build();
		getUser.get().setDob(user.getDob());
		getUser.get().setEmail(user.getEmail());
		getUser.get().setName(user.getName());
		getUser.get().setPassword(user.getPassword());
		getUser.get().setGender(user.getGender());
		
		User updateUser = this.userService.saveUser(getUser.get());
		return ResponseEntity.ok().body(updateUser);
	}

	@PostMapping("user/{id}")
	public ResponseEntity<Optional<User>> delete(@PathVariable(value = "id") int id) {
		Optional<User> user = this.userService.getOne(id);
		if (user == null)
			return ResponseEntity.notFound().build();
		this.userService.delete(user.get());
		return ResponseEntity.ok().body(user);
	}

	@RequestMapping(value = "signup", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String createUser() {
		// return Response.build();

		return "Noob";
		// return "SignUp";
	}

	@PostMapping("/login")
	public String loginUser() {
		return "SignUp";
	}

}
