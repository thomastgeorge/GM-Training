package com.grayMatter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grayMatter.Exception.ResourceNotFoundException;
import com.grayMatter.services.CandidateService;

@RestController
@RequestMapping("api/v1")
public class AuthController {
	
	@Autowired
	private CandidateService candidateService;
	
	@GetMapping("/login/admin/{username}/{password}")
	public String adminLogin(@PathVariable String username, @PathVariable String password) {
		if (username.equals("admin") && password.equals("admin")) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
	}
	
	@GetMapping("/login/candidate/{email}/{password}")
	public String candidateLogin(@PathVariable String email, @PathVariable String password) throws ResourceNotFoundException{
		if (candidateService.loginCandidate(email, password)) {
            return "Login successful";
        } else {
            return "Invalid credentials";
        }
	}

}
