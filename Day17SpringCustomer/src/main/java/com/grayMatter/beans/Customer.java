package com.grayMatter.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Component
public class Customer {
	
	//@Value("${Author.id}")
	private int id;
	//@Value("${Author.name}")
	private String name;
	//@Value("${Author.mobile}")
	private String mobile;
	//@Value("${Author.email}")
	private String email;
	@Autowired
	private Order order;

}
