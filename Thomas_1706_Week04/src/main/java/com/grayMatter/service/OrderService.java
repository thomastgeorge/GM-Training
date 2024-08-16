package com.grayMatter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayMatter.dao.OrderDao;
import com.grayMatter.model.Order;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao oDao;
	
	public List<Order> getAllOrder(){
		return oDao.getAllOrder();
	}

	public int addOrder(Order o) {
		return oDao.addOrder(o);
	}
	
	public List<Order> getOrderByOId(int oid) {
		return oDao.getOrderByOId(oid);
	}
	
	public List<Order> getOrderByCId(int cid) {
		return oDao.getOrderByCId(cid);
	}
	
	public int updateOrder(Order o) {
		return oDao.updateOrder(o);
	}
	
	public int deleteOrderByOid(int oid) {
		return oDao.deleteOrderByOid(oid);
	}
	
	public int deleteOrderByCid(int cid) {
		return oDao.deleteOrderByCid(cid);
	}

	
}