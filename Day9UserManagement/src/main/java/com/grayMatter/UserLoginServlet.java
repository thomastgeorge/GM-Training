package com.grayMatter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("Welcome!!");
		
		DataSourceClass dc = new DataSourceClass();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String rspswd=null;
		
		try {
			con = dc.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		String query = "SELECT upswd FROM User WHERE uemail = ?";
		
		try {
			ps = con.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String uemail = request.getParameter("uemail");
		String upswd = request.getParameter("upswd");
		
		try {
			ps.setString(1, uemail);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			rs=ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if (rs.next()) {
				rspswd= rs.getString("upswd");

			} else {
			    out.println("No user found with email: " + uemail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(upswd.equals(rspswd)) {
			out.println("User Logged In");
			out.println("Welcome Back!!!");
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
