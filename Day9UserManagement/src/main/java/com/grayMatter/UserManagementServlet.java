package com.grayMatter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserManagement
 */
public class UserManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserManagementServlet() {
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
		int count=0;
		RequestDispatcher dispatcher=null;
		
		try {
			con = dc.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		out.println("SQL Connection Established. Hooray!!!");
		
		String uname = request.getParameter("uname");
		String uemail = request.getParameter("uemail");
		String upswd = request.getParameter("upswd");
		String uphno = request.getParameter("uphno");
		
		String query = "INSERT INTO User (uname, uemail, upswd, uphno) VALUES(?, ?, ?, ?)";
		
		try {
			ps=con.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ps.setString(1,uname);
			ps.setString(2, uemail);
			ps.setString(3, upswd);
			ps.setString(4, uphno);
			
			count = ps.executeUpdate();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		if(count>0) {
			out.println("User Created");
			dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		else {
			dispatcher=request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request, response);
		}
		
		out.close(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
