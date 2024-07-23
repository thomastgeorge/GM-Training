package com.assignmet;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OrderClass {

	public static void main(String[] args) {
		
		
		//Order order = new Order(1,new Date(12, 1, 2024));
		
		Item item1 = new Item(1, 50, "Keyboard", "Logitech");
        Item item2 = new Item(2, 30, "Mouse", "Microsoft");
        Item item3 = new Item(3,100, "Laptop", "Apple");
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        
        Date orderDate = new Date(0,0,0); // current date
        
        Order order = new Order(1, orderDate);
        order.setList(items);

        // Creating a new Date (assuming you're using java.util.Date, though it's recommended to use java.time.LocalDate)
		
		int totalCost = order.getTotalCost();
		System.out.println("Total Order Cost: " + totalCost);
		System.out.println("Oder Data: "+order.getOrderDate());
		
		System.out.println("Printing max item");
        Item maxPricedItem = order.getMaxPricedItem();
        if (maxPricedItem != null)
            System.out.println(maxPricedItem);
		
		

	}

}