package com.assignmet;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		// TODO Auto-generated method stub
		return o1.getBrand().compareToIgnoreCase(o2.getBrand());
	}
}