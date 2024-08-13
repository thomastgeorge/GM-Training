package com.grayMatter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Orders {
	
	private int id;
	private String itemName;
	private int totalCost;
	private int orderQuantity;

}