package com.grayMatter;

public class Item {
	private String itemName;
	private int nou;
	private double price;
	private String brand;
	
	
	public Item() {
		super();
	}
	public Item(String itemName, int nou, double price, String brand) {
		super();
		this.itemName = itemName;
		this.nou = nou;
		this.price = price;
		this.brand = brand;
	}
	public String getItemName() {
		return itemName;
	}
	public int getNou() {
		return nou;
	}
	public double getPrice() {
		return price;
	}
	public String getBrand() {
		return brand;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setNou(int nou) {
		this.nou = nou;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", nou=" + nou + ", price=" + price + ", brand=" + brand + "]";
	}
	
	

}
