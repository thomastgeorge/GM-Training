package com.graymatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtTokenProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtTokenProjectApplication.class, args);
		System.out.println("Server up and runing");
	}

}
