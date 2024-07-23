package com.assignmet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private int id;
	private Date orderDate;
	private List<Item> item;

	//cal total order cost, find max(order)
	
	
	public Order() {
		super();
	}
	public Order(int orderId, Date orderDate) {
		super();
		this.id = orderId;
		this.orderDate = orderDate;
		this.item =  new ArrayList<>();
	}
	
	public void addItems(Item item) {
		this.item.add(item);
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<Item> getList() {
		return item;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + id + ", orderDate=" + orderDate + ", list=" + item + "]";
	}
	
	
	
	public int getTotalCost() {
		
		int total =0;
		
		for(Item it: item) {
			total += it.getPrice();
		}
		return total;
	}
	
	public Item getMaxPricedItem() {
		
		if (item.isEmpty()) {
            return null; // No items in the order
        }

        Item maxItem = item.get(0);
        for (Item item : item) {
            if (item.getPrice() > maxItem.getPrice()) {
                maxItem = item;
            }
        }
        return maxItem;
	}
	public void setList(List<Item>item) {
		this.item = item;
		
	}
}
