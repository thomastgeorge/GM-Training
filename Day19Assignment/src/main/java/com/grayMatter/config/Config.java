package com.grayMatter.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



@Configuration
@ComponentScan("com.grayMatter")
@EnableWebMvc
public class Config {
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource datasorse = new DriverManagerDataSource();
		datasorse.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasorse.setUrl("jdbc:mysql://localhost:3306/graymatter");
		datasorse.setUsername("root");
		datasorse.setPassword("password");
		return datasorse;

	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

}
