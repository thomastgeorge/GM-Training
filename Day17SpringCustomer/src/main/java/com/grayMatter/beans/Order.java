package com.grayMatter.beans;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Component
public class Order {
	
	//@Value("${Order.orderId}")
	private int orderId;
	//@Value("${Order.orderDate}")
	private String orderDate;
	@Autowired
	private ArrayList<Item> itemList;

}
