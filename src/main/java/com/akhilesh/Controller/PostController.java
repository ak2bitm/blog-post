package com.akhilesh.Controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akhilesh.Entity.Comment;
import com.akhilesh.Entity.Post;
import com.akhilesh.exception.ResourceNotFoundException;
import com.akhilesh.repo.CommentRepository;
import com.akhilesh.repo.PostRepository;


@RestController
public class PostController {

	@Autowired
	PostRepository postRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@GetMapping("/posts")
	public List<Post> getAllPost(){
		return  postRepository.findAll();
	}
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable Integer id)throws ResourceNotFoundException{
		
		Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post not found with id :"+id));
		return  ResponseEntity.ok().body(post);
	}
	
	
	@PostMapping("/posts")
	public Post createPost(@RequestBody Post post) {
		return postRepository.save(post);
	}
	
	@DeleteMapping("/posts/{id}")
	public Map<String, Boolean> deletePost(@PathVariable Integer id)throws ResourceNotFoundException{
		Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post not found with id :"+id));
		postRepository.delete(post);
		Map<String, Boolean> result = new HashMap<>();
		result.put("deleted", Boolean.TRUE);
		
		return result;
	}
	
	@PostMapping("/comments")
	public Comment createComment(@RequestBody Comment comments) {
		return commentRepository.save(comments);
	}
}
