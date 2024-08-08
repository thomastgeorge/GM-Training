package com.grayMatter.config;

import java.util.ArrayList;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.grayMatter.beans.Customer;
import com.grayMatter.beans.DataSource;
import com.grayMatter.beans.Item;
import com.grayMatter.beans.Order;

@Configuration
@ComponentScan("com.grayMatter.beans")
//@PropertySource("classpath:data.properties")
public class CustomerConfig {
	
	@Bean(name="cust")
	public Customer getCustomer() {
		Order order = getOrder();
		Customer c = new Customer(1,"user","1234567890", "user@gmail.com", order);
		return c;
	}

	@Bean
	public Order getOrder() {
		ArrayList<Item> al = getItems();
		Order order = new Order(1, "06/08/2024", al);
		return order;
	}
	
	@Bean
	public ArrayList getItems() {
		Item i1 = new Item(1,"Item1",10);
		Item i2 = new Item(2,"Item2",20);
		ArrayList<Item> al = new ArrayList<>();
		al.add(i1);
		al.add(i2);
		return al;
	}
}
