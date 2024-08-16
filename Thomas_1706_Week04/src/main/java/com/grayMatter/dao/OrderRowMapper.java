package com.grayMatter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.grayMatter.model.Order;


public class OrderRowMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order o = new Order(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4));
		return o;
	}

}