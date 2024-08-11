package com.grayMatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.grayMatter.model.Post;

@Component
public class PostDao {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public int addPost(Post post) {
		String query = "insert into post values ("+post.getId()+",'"+post.getTitle()+"','"+post.getContent()+"','"+post.getAuthor()+"');";
		return jdbcTemplate.update(query);
	}
	
	public List<Post> getAllPosts() {
		String query = "select * from post";
		return jdbcTemplate.query(query, new PostMap());
	}
	
	public int deletePost(int id) {
		String query = "delete from post where id="+id;
		return jdbcTemplate.update(query);
	}
	
	public int updatePost(Post post) {
		String query = "update post set content='"+post.getContent()+"' where id="+post.getId();
		return jdbcTemplate.update(query);
	}
	
	public Post getPostById(int id) {
		
		System.out.println("inside");
		String query1 = "select * from post where id="+id;
		List<Post> ps = jdbcTemplate.query(query1, new PostMap());
		
		System.out.println("data"+ps);
		
		if(ps.isEmpty()) return null;
		
		System.out.println("inside :"+ps);
		
		return ps.get(0);
	}
	
}
