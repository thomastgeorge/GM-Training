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

//import com.google.protobuf.Parser;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
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
		//out.print("Welcome!!");
		
		DataSourceClass dc = new DataSourceClass();
		Connection con=null;
		PreparedStatement ps=null;
		int count1=0, count2=0;
		RequestDispatcher dispatcher=null;
		
		try {
			con = dc.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		String cname = request.getParameter("name");
		String cemail = request.getParameter("email");
		String cmobile = request.getParameter("mobile");
		String cpassword = request.getParameter("password");
		String caccountType = request.getParameter("account-type");
		String pin = request.getParameter("pin");
		
		// 1 Savings Account
        // 2 Current Account
		int caccount = Integer.parseInt(caccountType);
		int apin = Integer.parseInt(pin);
		
		String query1 = "INSERT INTO customer (cname, cemail, cmobile, cpwd, caccount) VALUES(?, ?, ?, ?, ?)";
		
		try {
			ps=con.prepareStatement(query1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ps.setString(1,cname);
			ps.setString(2, cemail);
			ps.setString(3, cmobile);
			ps.setString(4, cpassword);
			ps.setInt(5, caccount);
			
			count1 = ps.executeUpdate();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		String query2 = "INSERT INTO account (cemail, balance, pin) VALUES(?, 0, ?)";
		
		try {
			ps=con.prepareStatement(query2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ps.setString(1, cemail);
			ps.setInt(2, apin);
			
			count2 = ps.executeUpdate();
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
		if(count1>0 && count2>0) {
			//out.println("User Created");
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
