package com.graymatter.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {

	private int pid;
	private String name;
	private String description;
	private double price;
	private int stockQuantity;
	private String category;
	private String tags;
	private String imageUrl;
	private float rating;
	private int ratingcount;
	private Date createdDate;
	
}
