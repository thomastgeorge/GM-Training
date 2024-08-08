package com.grayMatter.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
public class DataSource {
	
	private String driver;
	private String url;
	private String uname;
	private String pwd;
	
	@PostConstruct
	public void setUp() {
		driver="com.mysql.cj.jdbc.Driver";
		url="jdbc:mysql://localhost:3306/graymatterdb";
		uname="root";
		pwd="password";
		System.out.println("Setup Done");
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url,uname,pwd);
		return con;
		
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy Method");
	}

}
