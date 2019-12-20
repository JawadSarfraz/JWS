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

import com.test.entities.Comment;
import com.test.entities.Post;
import com.test.entities.User;
import com.test.service.CommentService;
import com.test.service.PostService;
import com.test.service.UserService;

@RestController
@RequestMapping("/comment")

public class CommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping("/")
	public String index (){

			// TODO Auto-generated method stub
			
//			User u1 = new User("asaz","aas","qw",15,"qew","azz","zxc","xsc",15);
			
			Optional<Comment> temp = commentService.getOne(5);
			if (temp.isPresent()) {
	            System.out.println(temp.get());
	        } else {
	            System.out.printf("No city found with id %d%n", temp);
	        }
		//	System.out.print(temp.getClass().getName());
		return "Meowwwww....";
	}


	@PostMapping("/signUp")
	public Comment createUser(@Valid @RequestBody Comment comment) {
		// return Response.build();
		return this.commentService.saveComment(comment);
	}

	@GetMapping("/findAllUser")
	public ResponseEntity<List<Comment>> getAllUser() {
		List<Comment> comment = this.commentService.findAll();
		if (comment== null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(comment);
	}

	// get one user
	/*
	 * @GetMapping("/findUser/{id}") public ResponseEntity<User>
	 * getUse(@PathVariable(value = "id") Long id) { User user =
	 * this.userService.getOne(id); if (user == null) return
	 * ResponseEntity.notFound().build(); return ResponseEntity.ok().body(user); }
	 * 
	 * @PostMapping("/update/{id}") public ResponseEntity<User>
	 * update(@PathVariable(value="id") Long id,@Valid @RequestBody User user){ User
	 * getUser = this.userService.getOne(id); if(getUser==null) return
	 * ResponseEntity.notFound().build(); getUser.setCity(user.getCity());
	 * getUser.setCountry(user.getCountry()); getUser.setDob(user.getDob());
	 * getUser.setEmail(user.getEmail()); getUser.setName(user.getName());
	 * getUser.setPassword(user.getPassword());
	 * getUser.setUsername(user.getUsername());
	 * 
	 * User updateUser = this.userService.saveUser(getUser); return
	 * ResponseEntity.ok().body(updateUser); }
	 * 
	 * @PostMapping("user/{id}") public ResponseEntity<User>
	 * delete(@PathVariable(value="id") Long id){ User user =
	 * this.userService.getOne(id); if(user==null) return
	 * ResponseEntity.notFound().build(); this.userService.delete(user); return
	 * ResponseEntity.ok().body(user); }
	 */	

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
