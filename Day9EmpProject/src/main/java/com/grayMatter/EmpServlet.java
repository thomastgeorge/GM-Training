package com.grayMatter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpServlet
 */
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmpServlet() {
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
		out.print("Hello ");
		
		DataSourceClass dc = new DataSourceClass();
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con = dc.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		out.println("SQL Connection Established. Hooray!!!");
		
		String rid = request.getParameter("rid");
		String rname=request.getParameter("rname");
		
		String query = "INSERT INTO regions VALUES(?, ?)";
		
		try {
			ps=con.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ps.setInt(1, Integer.parseInt(rid));
			ps.setString(2, rname);
			ps.executeUpdate();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		out.println("Row Inserted");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
