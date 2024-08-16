package com.grayMatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.grayMatter.model.Order;


@Component
public class OrderDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int addOrder(Order o) {
		String query="INSERT INTO orders VALUES ("+o.getOid()+", "+o.getCid()+", "+o.getTamount()+" , '"+o.getOdate()+"' );";
		return jdbcTemplate.update(query);
	}
	
	public List<Order> getAllOrder(){
		String query = "SELECT * FROM orders";
		List<Order> oList = jdbcTemplate.query(query, new OrderRowMapper());
		return oList;
	}
	
	public int updateOrder(Order o) {
		String query="UPDATE orders SET tamount="+o.getTamount()+" WHERE oid= "+o.getOid();
		return jdbcTemplate.update(query);
	}
	
	public int deleteOrderByOid(int oid) {
		String query="DELETE FROM orders WHERE oid= "+oid;
		return jdbcTemplate.update(query);
	}
	
	public int deleteOrderByCid(int cid) {
		String query="DELETE FROM orders WHERE cid="+cid;
		return jdbcTemplate.update(query);
	}
	
	public List<Order> getOrderByOId(int oid) {
		String query="SELECT * FROM orders WHERE oid="+oid;
		List<Order> oList = jdbcTemplate.query(query, new OrderRowMapper());
		return oList;
	}

	public List<Order> getOrderByCId(int cid) {
		String query="SELECT * FROM orders WHERE cid="+cid;
		List<Order> oList = jdbcTemplate.query(query, new OrderRowMapper());
		return oList;
	}
}
