package com.test.controller;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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

import com.test.dto.PostDto;
import com.test.dto.UserDto;
import com.test.entities.User;
import com.test.service.UserService;

@RestController
@RequestMapping("/user")

public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
    private ModelMapper modelMapper;

	@RequestMapping("/")
	public String index() {		Optional<User> temp = userService.getOne(15);
		if (temp.isPresent()) {
			System.out.println(temp.get());
		} else {
			System.out.println("No User found");
		}
		System.out.print(temp.getClass().getName());
		return "Meowwwww....";
	}
	@PostMapping("/signUp")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody User user) {
		// return Response.build();
		user = this.userService.saveUser(user);
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return ResponseEntity.ok().body(userDto);
	}

	@GetMapping("/findAllUser")
	public ResponseEntity<List<UserDto>> getAllUser() {
		List<User> users = this.userService.findAll();
		if (users == null)
			return ResponseEntity.notFound().build();
		Type listType = new TypeToken<List<UserDto>>(){}.getType();
		List<UserDto> userDtoList = this.modelMapper.map(users,listType);
		return ResponseEntity.ok().body(userDtoList);
	}

	@GetMapping("/findUser/{id}")
	public ResponseEntity<UserDto> getUse(@PathVariable(value = "id") int id) {
		Optional<User> user = this.userService.getOne(id);
		if (user == null)
			return ResponseEntity.notFound().build();
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return ResponseEntity.ok().body(userDto);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<UserDto> update(@PathVariable(value = "id") int id, @Valid @RequestBody User user) {
		Optional<User> getUser = this.userService.getOne(id);
		if (getUser == null)
			return ResponseEntity.notFound().build();
		getUser.get().setDob(user.getDob());
		getUser.get().setEmail(user.getEmail());
		getUser.get().setName(user.getName());
		getUser.get().setPassword(user.getPassword());
		getUser.get().setGender(user.getGender());
		
		User updateUser = this.userService.saveUser(getUser.get());
		UserDto userDto = this.modelMapper.map(updateUser, UserDto.class);
		return ResponseEntity.ok().body(userDto);
	}
	//check the return stuff. maybe a String...???
	@PostMapping("delete/{id}")
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

	@PostMapping("/sign")
	public void createUse() {
		// return Response.build();
		int a =1;
		System.out.print(a);
		//return this.userService.saveUser(user);
	}


}
