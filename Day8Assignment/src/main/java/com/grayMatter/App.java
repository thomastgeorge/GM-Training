package com.grayMatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
	static final String Driver="com.mysql.cj.jdbc.Driver";
    public static void main( String[] args ) throws SQLException
    {
    	System.out.println("Driver loaded");
		
		String url="jdbc:mysql://localhost:3306/graymatterdb";
		String username="root";
		String password = "password";
		
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("Connection Established");
		
		createTable(con); // Create table if not exists
		
		boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Create Record");
            System.out.println("2. Read Records");
            System.out.println("3. Update Record");
            System.out.println("4. Delete Record");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(System.console().readLine());

            switch (choice) {
                case 1:
                    createRecord(con);
                    break;
                case 2:
                    readRecords(con);
                    break;
                case 3:
                    updateRecord(con);
                    break;
                case 4:
                    deleteRecord(con);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
        
    }
    
    private static void createTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Records (" +
                     "id INT PRIMARY KEY AUTO_INCREMENT," +
                     "name VARCHAR(15) NOT NULL)";
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
        System.out.println("Table Created\n");
    }

    private static void createRecord(Connection conn) throws SQLException {
        System.out.print("Enter name: ");
        String name = System.console().readLine().trim();

        String sql = "INSERT INTO Records (name) VALUES (?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.executeUpdate();
        
        pstmt.close();

        System.out.println("Record created successfully.");
    }

    private static void readRecords(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Records");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");

            System.out.println("ID: " + id + ", Name: " + name);
        }

        rs.close();
        stmt.close();
    }

    private static void updateRecord(Connection conn) throws SQLException {
        System.out.print("Enter ID of record to update: ");
        int id = Integer.parseInt(System.console().readLine().trim());
        System.out.print("Enter new name: ");
        String name = System.console().readLine().trim();

        String sql = "UPDATE Records SET name = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setInt(2, id);
        int rowsUpdated = pstmt.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("No record found with ID " + id);
        }
        
        pstmt.close();
    }

    private static void deleteRecord(Connection conn) throws SQLException {
        System.out.print("Enter ID of record to delete: ");
        int id = Integer.parseInt(System.console().readLine().trim());

        String sql = "DELETE FROM Records WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        int rowsDeleted = pstmt.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("No record found with ID " + id);
        }
        
        pstmt.close();
    }
}
