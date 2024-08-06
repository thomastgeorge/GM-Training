package com.grayMatter.beans;

import java.util.List;

public class Order {
	
	private int orderId;
	private List<String> itemList;
	
	public Order() {
		super();
	}
	
	public Order(int orderId, List<String> itemList) {
		super();
		this.orderId = orderId;
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", itemList=" + itemList + "]";
	}

}
