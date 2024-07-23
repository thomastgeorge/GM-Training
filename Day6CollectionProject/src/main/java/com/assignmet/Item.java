package com.assignmet;


import java.util.Comparator;

public class Item implements Comparable<Item>{
	
	private int nou;
	private int price;
	private String itemName;
	private String brand;
	
	public Item() {
		super();	
	}
	
	public Item(int nou, int price, String itemName, String brand) {
		super();
		this.nou = nou;
		this.price = price;
		this.itemName = itemName;
		this.brand = brand;
	}



	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getNou() {
		return nou;
	}
	public void setNou(int nou) {
		this.nou = nou;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Item [nou=" + nou + ", price=" + price + ", itemName=" + itemName + ", brand=" + brand + "]";
	}

	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		return this.nou - o.nou;
	}
	
	
}
