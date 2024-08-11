package com.grayMatter.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grayMatter.dao.PostDao;
import com.grayMatter.model.Post;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	
	private final PostDao postDao;
	
	public ResponseEntity<String> addPost(Post post) {
		
		if (post == null) {
			return ResponseEntity.badRequest().body("Post or Post ID is null");
		}
		
//		String val = post.getId();
		Post postData = postDao.getPostById(post.getId());
		
		if(postData == null) {
			postDao.addPost(post);
			return ResponseEntity.ok("Data Added Successfully");
		}
		
		System.out.println(post);
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body("post Already exits in the database");
		
	}
	
	
	public ResponseEntity getById(int id) {
		
		System.out.println("inside getById: "+id);
		
		Post data = postDao.getPostById(id);
		
		System.out.println("inside getById: "+data);
		
		if(data == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data not present in the database");
		}
		
		return ResponseEntity.ok(data);
		
	}
	
	public ResponseEntity<String> updatePost(Post post) {
		
		int i = postDao.updatePost(post);
		
		if(i != 0) {
			return ResponseEntity.ok("post updated");
		}
		
		return ResponseEntity.ok("post not found");
		
	}
	
	public ResponseEntity<String > deletePost(int id) {
		
		int i = postDao.deletePost(id);
		
		System.out.println("Data deleting : "+ i);
		
		if(i != 0) {
			return ResponseEntity.ok("data deleted");
		}
		
		return ResponseEntity.ok("data not found");
	}
	
	
	public ResponseEntity getAllData() {
		List<Post> data = postDao.getAllPosts();
		
		if(data.isEmpty()) {
			return ResponseEntity.ok("Data is Empty");
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(data);
	}

}
