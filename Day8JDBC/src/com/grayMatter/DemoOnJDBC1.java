package com.grayMatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoOnJDBC1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded");
		
		String url = "jdbc:mysql://localhost:3306/graymatterdb";
		String root="root";
		String password="password";
		
		Connection con=DriverManager.getConnection(url, root, password);
		System.out.println("Connection Established");
		
		String query = "update regions set region_name=? where region_id=?";
		PreparedStatement ps=con.prepareStatement(query);
		
		ps.setString(1, "Africa");
		ps.setInt(2, 6);
		ps.executeUpdate();
		System.out.println("Row Updated sucessfully");
		
		String query1 = "delete from regions where region_id=?";
		ps = con.prepareStatement(query1);
		ps.setInt(1, 6);
		ps.executeUpdate();
		System.out.println("Row deleted");
		
		ps.close();
		
		Statement st = con.createStatement();
		String query2 = "SELECT * FROM regions";
		
		ResultSet rs=st.executeQuery(query2);
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) +" " + rs.getString(2));
		}
		rs.close();
		st.close();
		
		
		
	}

}
