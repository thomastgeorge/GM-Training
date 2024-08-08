package com.grayMatter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.grayMatter.beans.Author;
import com.grayMatter.beans.Book;

//configuration to the application
@Configuration
@ComponentScan("com.grayMatter.beans")
@PropertySource("classpath:bookData.properties")
public class BookConfig {
	
	//define bean
	//supply value to bean property
	
//	//@Bean(name="book")
//	public Book getBook() {
//		return new Book("Java", "1234", 123, getAuthor());
//	}
//	
//	//@Bean(name="author")
//	public Author getAuthor() {
//		return new Author("User", 123);
//	}

}