package com.grayMatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.grayMatter.model.Customer;

@Component
public class CustomerDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int addCustomer(Customer c) {
		String query="INSERT INTO customer VALUES ("+c.getCid()+", '"+c.getCname()+"' , '"+c.getCemail()+"' , '"+c.getCpwd()+"')";
		return jdbcTemplate.update(query);
	}
	
	public List<Customer> getAllCustomer(){
		String query = "SELECT * FROM customer";
		List<Customer> cList = jdbcTemplate.query(query, new CustomerRowMapper());
		return cList;
	}
	
	public int updateCustomerName(String cname, int cid) {
		String query="UPDATE customer SET cname= '"+cname+"' WHERE cid="+cid;
		return jdbcTemplate.update(query);
	}
	
	public int deleteCustomer(int cid) {
		String query="DELETE FROM customer WHERE cid="+cid;
		return jdbcTemplate.update(query);
	}
	
	public Customer getCustomerById(int cid) {
		String query="SELECT * FROM customer WHERE cid="+cid;
		List<Customer> cList = jdbcTemplate.query(query, new CustomerRowMapper());
		return cList.get(0);
	}
	
	public Customer getCustomerByEmail(String cemail) {
		String query="SELECT * FROM customer WHERE cemail= '"+cemail+"'";
		List<Customer> cList = jdbcTemplate.query(query, new CustomerRowMapper());
		return cList.get(0);
	}

}