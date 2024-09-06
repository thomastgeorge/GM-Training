package com.grayMatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Thomas1706Week08ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Thomas1706Week08ServerApplication.class, args);
		System.out.println("Eureka Server up and running");
	}

}
