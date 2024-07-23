package com.grayMatter;

import java.util.Comparator;

public class ItemNameComparator implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		return o1.getItemName().compareTo(o2.getItemName());
	}

}
