package com.grayMatter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayMatter.dao.CustomerDao;
import com.grayMatter.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao cDao;
	
	public List<Customer> getAllCustomer(){
		return cDao.getAllCustomer();
	}

	public int addCustomer(Customer c) {
		return cDao.addCustomer(c);
	}
	
	public Customer getCustomerById(int cid) {
		return cDao.getCustomerById(cid);
	}
	
	public Customer getCustomerByEmail(String cemail) {
		return cDao.getCustomerByEmail(cemail);
	}
	
	public int updateCustomerName(String cname, int cid) {
		return cDao.updateCustomerName(cname, cid);
	}
	
	public int deleteCustomer(int cid) {
		return cDao.deleteCustomer(cid);
	}
	
}