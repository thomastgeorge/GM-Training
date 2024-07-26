package com.grayMatter;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ShoppingCart {
	private ArrayList<Item> items = new ArrayList<>();
    private double discount = 0.0;
    
	public ShoppingCart() {
		super();
	}
	public ShoppingCart(ArrayList<Item> items, double discount) {
		super();
		this.items = items;
		this.discount = discount;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "ShoppingCart [items=" + items + ", discount=" + discount + "]";
	}
    
	public void addToCart(Item i) {
		items.add(i);
	}
	
	public void removeFromCart(Item i) {
		items.removeIf(item-> item.getProductName().equals(i.getProductName()));
	}
	
	public double getTotalAmount() {
        return items.stream()
                    .mapToDouble(item -> item.getTotalPrice())
                    .sum();
    }
	
	public void showCart() {
        items.forEach(item -> System.out.println(item.getProductName() + ": " + item.getQuantity()));
        System.out.println("\n");
	}
	
	Predicate<String> predicate=(coupon->coupon.equals("IND10"));
	
	public void applyCoupon(String coupon) {
        if (predicate.test(coupon)) {
            discount =10.0;
        } else {
            discount = 0.0;
        }
    }
	
	public double getPayableAmount() {
        double totalAmount = getTotalAmount();
        float disAmount = (float) (totalAmount * (discount/100));
        double tax = (totalAmount - disAmount) * 0.14;
        return (totalAmount - disAmount) + tax;

    }
	
    public void printInvoice() {
    	items.forEach(item ->{
    		System.out.println(item.getProductName()+" "+item.getQuantity()+" "+
    				item.getUnitPrice()+" "+item.getTotalPrice());    		
    	});
    	double totalAmount=getTotalAmount();
		System.out.println("\t\tTotal: "+ totalAmount);
		float disAmount = (float) (totalAmount * (discount/100));
		System.out.println("\t\tDisc: "+ disAmount);
		double tax = (totalAmount - disAmount) * 0.14;
		System.out.println("\t\tTax: "+ (float) tax);
        System.out.println("\t\tTotal: "+ getPayableAmount());
		System.out.println("\n");
    }

}
