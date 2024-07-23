package com.grayMatter;

import java.util.Comparator;

public class BrandComparator implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		return o1.getBrand().compareTo(o2.getBrand());
	}

}
