package com.grayMatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoOnJDBC {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		
		String url="jdbc:mysql://localhost:3306/graymatterdb";
		String username="root";
		String password = "password";
		
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Connection Established");
		
		
//		Statement st = con.createStatement();
//		String query = "SELECT first_name, employee_id FROM employees";
//		
//		ResultSet rs=st.executeQuery(query);
//		
//		while(rs.next()) {
//			System.out.println(rs.getString(1) +" " + rs.getInt(2));
//		}
		

//		String query="INSERT INTO regions VALUES (?, ?)";
//		PreparedStatement ps = con.prepareStatement(query);
//		ps.setInt(1, 6);
//		ps.setString(2, "Australia");
//		int row = ps.executeUpdate(); // returns how many rows gets affected
//		System.out.println("rows Inserted: "+row);
//		
//		ps.close();
		
		
		Statement st = con.createStatement();
		String query1 = "SELECT * FROM regions";
		
		ResultSet rs=st.executeQuery(query1);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) +" " + rs.getString(2));
		}
		
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println(rsmd);
		
//		rs.close();
//		st.close();
		con.close();
		
	}

}
