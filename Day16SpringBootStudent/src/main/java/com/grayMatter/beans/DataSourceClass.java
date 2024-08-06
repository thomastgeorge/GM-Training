package com.grayMatter.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceClass {
	
	private String driverName;
	private String url;
	private String uname;
	private String pwd;
		
	public DataSourceClass() {
		super();
	}
	
	public DataSourceClass(String driverName, String url, String uname, String pwd) {
		super();
		this.driverName = driverName;
		this.url = url;
		this.uname = uname;
		this.pwd = pwd;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "DataSource [driverName=" + driverName + ", url=" + url + ", uname=" + uname + ", pwd=" + pwd + "]";
	}
	
	 public Connection getConnection() throws SQLException {
		 try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Connection con = null;
		 con = DriverManager.getConnection(url, uname, pwd);
		 return con;
	 }

}
