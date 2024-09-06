package com.grayMatter.dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDto {
	
	private int oid;
	private Date date;
	private float totalCost;
	private List<Integer> itemsIds;

}
