package com.test.controller;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.test.entities.Post;
import com.test.entities.User;
import com.test.service.PostService;
import com.test.service.UserService;

@RestController
@RequestMapping("/post")

public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@RequestMapping("/")
	public String index (){
//			User u1 = new User("asaz","aas","qw",15,"qew","azz","zxc","xsc",15);
			Optional<Post> temp = postService.getOne(5);
			if (temp.isPresent()) {
	            System.out.println(temp.get());
	        } else {
	            System.out.printf("No post found with");
	        }
		return "Meowwwww....";
	}

	@PostMapping("/signUp")
	public ResponseEntity<PostDto> createPost(@Valid @RequestBody Post post) {	
		Optional<User> userObj = userService.getOne(post.getUser().getId());
		
		if(userObj.isPresent()) {
			post.setUser(userObj.get());
			post = this.postService.savePost(post);
			if(post != null) {
				PostDto postDto = modelMapper.map(post, PostDto.class);
				return ResponseEntity.ok().body(postDto);
			}
		}
		return ResponseEntity.notFound().build();
	}
	@GetMapping("/findAllPost")
	public ResponseEntity<List<PostDto>> getAllPost() {
		List<Post> posts = this.postService.findAll();
		if (posts == null)
			return ResponseEntity.notFound().build();
		
		Type listType = new TypeToken<List<PostDto>>(){}.getType();
		List<PostDto> postDtoList = this.modelMapper.map(posts,listType);
		return ResponseEntity.ok().body(postDtoList);
	}
	
	@GetMapping("/findPost/{id}")
	public ResponseEntity<PostDto> getUse(@PathVariable(value = "id") int id) {		
		Optional<Post> post= this.postService.getOne(id);
		if (post.isPresent() == false)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			return ResponseEntity.notFound().build();
		PostDto postDto = modelMapper.map(post.get(), PostDto.class);
		return ResponseEntity.ok().body(postDto);
	}
	
	@PostMapping("/deletePost/{id}")
	public ResponseEntity<PostDto> delete(@PathVariable(value = "id") int id) {
		Optional<Post> post = this.postService.getOne(id);
		if (post.isPresent() == false)
			return ResponseEntity.notFound().build();
		this.postService.delete(post.get());
		PostDto postDto = modelMapper.map(post.get(),PostDto.class);
		return ResponseEntity.ok().body(postDto);
	}
	@PostMapping("/update/{id}")
	public ResponseEntity<PostDto> update(@PathVariable(value = "id") int id, @Valid @RequestBody Post post) {
		Optional<Post> getPost = this.postService.getOne(id);
		if (getPost.isPresent() == false)
			return ResponseEntity.notFound().build();
		getPost.get().setDescription(post.getDescription());
		getPost.get().setLikes(post.getLikes());
		getPost.get().setStatus(post.getStatus());
		getPost.get().setTimeStamp(post.getTimeStamp());
		Post updateUser = this.postService.savePost(getPost.get());
		
		PostDto postDto = modelMapper.map(updateUser, PostDto.class);
		return ResponseEntity.ok().body(postDto);
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
