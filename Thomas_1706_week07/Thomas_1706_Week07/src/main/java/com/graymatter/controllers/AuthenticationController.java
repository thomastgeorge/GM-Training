package com.graymatter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graymatter.configuration.UserPrincipal;
import com.graymatter.dto.LoginResponse;
import com.graymatter.dto.LoginUserDTO;
import com.graymatter.dto.RegUserDTO;
import com.graymatter.entities.User;
import com.graymatter.services.AuthenticationService;
import com.graymatter.services.JwtService;

@RestController
@RequestMapping("api/v1/auth")
public class AuthenticationController {
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<User> signUp(@RequestBody RegUserDTO regUserDTO){
		User regUser = authService.signUp(regUserDTO);
		return ResponseEntity.ok(regUser);
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDTO loginUserDTO){
		User authenticatedUser = authService.login(loginUserDTO);
		
		String token = jwtService.generateToken(new UserPrincipal(authenticatedUser));
		LoginResponse loginResponse=new LoginResponse();
		loginResponse.setToken(token);
		loginResponse.setExpirationTime(jwtService.expirationTime());
		
		return ResponseEntity.ok(loginResponse);
		
		
		
	}

}
