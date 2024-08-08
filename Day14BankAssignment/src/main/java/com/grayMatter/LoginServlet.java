package com.grayMatter;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//out.print("Welcome!!");
		
		DataSourceClass dc = new DataSourceClass();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String rscname=null;
		String rspwd=null;
		int rscaccount=-1;
		int rsaccno=-1;
		int rsbalance=-1;
		RequestDispatcher dispatcher=null;
		
		try {
			con = dc.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		String query1 = "SELECT cname, cpwd, caccount FROM customer WHERE cemail = ?";
		
		try {
			ps = con.prepareStatement(query1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String cemail = request.getParameter("email");
		String cpwd = request.getParameter("password");
		
		try {
			ps.setString(1, cemail);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			rs=ps.executeQuery();
			if (rs.next()) {
				rspwd= rs.getString("cpwd");
				rscaccount = rs.getInt("caccount");
				rscname = rs.getString("cname");

			} else {
				dispatcher=request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String query2 = "SELECT accno, balance FROM account WHERE cemail = ?";
		
		
		try {
			ps = con.prepareStatement(query2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			ps.setString(1, cemail);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			rs=ps.executeQuery();
			if (rs.next()) {
				rsaccno = rs.getInt(1);
				rsbalance = rs.getInt("balance");

			} else {
				dispatcher=request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		if(cpwd.equals(rspwd)) {
			request.setAttribute("cname", rscname);
			request.setAttribute("caccount", rscaccount);
			request.setAttribute("accno", rsaccno);
			request.setAttribute("balance", rsbalance);
			if(rscaccount==1) {
				request.setAttribute("accountType", "Savings Account");
				dispatcher=request.getRequestDispatcher("account.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("accountType", "Current Account");
				dispatcher=request.getRequestDispatcher("account.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			dispatcher=request.getRequestDispatcher("login.jsp");
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
