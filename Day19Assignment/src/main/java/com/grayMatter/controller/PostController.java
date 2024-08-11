package com.grayMatter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.grayMatter.model.Post;
import com.grayMatter.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
public class PostController {
	
	private final PostService postService;
	
	
	@RequestMapping("log")
	public String log() {
		return "login";
	}
	
	@RequestMapping("/login")
	public ModelAndView getLog(@RequestParam String name, @RequestParam String pass) {
		
		System.out.println(name+" "+pass);
		
		if(name.equals("varma") && pass.equals("password")) {
			return new ModelAndView("home");
		}
		return new ModelAndView("login");
		
	}
	
	@RequestMapping("/addpost")
	public String add() {
		return "addPost";
	}
	
	@RequestMapping("/addPost")
	public ModelAndView addPost(@RequestParam String id,
			@RequestParam String title,
			@RequestParam String content,
			@RequestParam String author) {
			
		System.out.println(id);
		
		ResponseEntity<String> response = postService.addPost(new Post(Integer.parseInt(id), title, content, author));
		
		ModelAndView mv =new ModelAndView("result");
		
		return mv.addObject("message", response.getBody());
		
		
	}
	
	@RequestMapping("/getid")
	public String getId() {
		return "getId";
	}
	
	@RequestMapping("/getId")
	public ModelAndView gtById(@RequestParam String id) {
		
		System.out.println(id);
		ResponseEntity<Post> data = postService.getById(Integer.parseInt(id));
		
		ModelAndView mv= new ModelAndView("display");
		
		mv.addObject("message", data.getBody());
		
		return mv;
	}
	
	
	@RequestMapping("/del")
	public String del() {
		return "delete";
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int id) {
		
		ResponseEntity<String> response = postService.deletePost(id);
		
		ModelAndView mv = new ModelAndView("result");
		
		mv.addObject("messge", response.getBody());
		
		return mv;
	}
	
	
	@RequestMapping("/upp")
	public String upp() {
		return "update";
	}
	
	@RequestMapping("/update")
	public ModelAndView update(@RequestParam String id,
	@RequestParam String content) {
		
		Post post = Post.builder().id(Integer.parseInt(id)).content(content).build();
		
		ResponseEntity<String> response = postService.updatePost(post);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("message", response.getBody());
		return mv;
		
	}
	
	
	
	@RequestMapping("/all")
	public ModelAndView getAll() {
		ResponseEntity<String> response = postService.getAllData();
		
		ModelAndView mv = new ModelAndView("displayData");
		
		mv.addObject("message", response.getBody());
		
		return mv;
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	

	

}
