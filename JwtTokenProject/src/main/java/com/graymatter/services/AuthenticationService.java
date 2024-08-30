package com.graymatter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.graymatter.dto.LoginUserDTO;
import com.graymatter.dto.RegUserDTO;
import com.graymatter.entities.User;
import com.graymatter.repositories.UserRepository;

@Service
public class AuthenticationService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User signUp(RegUserDTO regUserDTO) {
		User user = new User();
		user.setUsername(regUserDTO.getUsername());
		user.setEmail(regUserDTO.getEmail());
		user.setPassword(passwordEncoder.encode(regUserDTO.getPassword()));
		return userRepository.save(user);
	}

	public User login(LoginUserDTO loginUserDTO) {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginUserDTO.getEmail(),
				loginUserDTO.getPassword()
				)
			);
		return userRepository.findByEmail(loginUserDTO.getEmail()).get();
	}

}
