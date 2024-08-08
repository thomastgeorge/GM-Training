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
public class Book {

	//@Value("Java")
	@Value("${Book.bookName}")
	private String bookName;
	//@Value("3434")
	@Value("${Book.isbnNum}")
	private String isbnNum;
	//@Value("123")
	@Value("${Book.price}")
	private double price;
	@Autowired
	private Author author;
}
