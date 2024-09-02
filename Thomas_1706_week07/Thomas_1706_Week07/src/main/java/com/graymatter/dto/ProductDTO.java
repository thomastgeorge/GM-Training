package com.graymatter.dto;

import java.sql.Date;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {

	@Positive(message = "Product ID must be positive.")
    private int pid;

    @NotBlank(message = "Name cannot be null or empty.")
    private String name;

    private String description;

    @PositiveOrZero(message = "Price cannot be negative.")
    private double price;

    @PositiveOrZero(message = "Stock quantity cannot be negative.")
    private int stockQuantity;

    @NotBlank(message = "Category cannot be null or empty.")
    private String category;

    private String tags; // Optional validation

    @NotBlank(message = "Image URL cannot be null or empty.")
    @Pattern(regexp = "^http", message = "Image URL must be a valid URL starting with 'http'.")
    private String imageUrl;

    @DecimalMin(value = "0.0", inclusive = false, message = "Rating must be greater than 0.")
    @DecimalMax(value = "5.0", inclusive = true, message = "Rating must be between 0 and 5.")
    private float rating;

    @PositiveOrZero(message = "Rating count cannot be negative.")
    private int ratingCount;

    @NotNull(message = "Created date cannot be null.")
    private Date createdDate;
	
}
