package com.grayMatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients
public class Thomas1706Week08OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(Thomas1706Week08OrderApplication.class, args);
		System.out.println("Orders Client Microservice up and running");
	}

}
