package com.grayMatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grayMatter.entities.Orders;
import com.grayMatter.repositories.OrdersRepository;

@Repository
public class OrdersDao {
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	public Orders getOrdersById(int oid) {
		return ordersRepository.findById(oid).get();
	}
	
	public List<Orders> getAllOrders() {
		return ordersRepository.findAll();
	}
	
	public Orders addOrders(Orders orders) {
		return ordersRepository.save(orders);
	}
	
	public List<Orders> getOrdersByItemIds(List<Integer> itemIds){
		return ordersRepository.findByItemsIdsIn(itemIds);
	}

}
