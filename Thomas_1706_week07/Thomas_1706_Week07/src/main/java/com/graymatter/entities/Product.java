package com.graymatter.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "week7product")
public class Product {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
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
