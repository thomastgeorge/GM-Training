package com.graymatter.dto;

import org.springframework.stereotype.Component;

import com.graymatter.entities.Product;

@Component
public class ProductMapper {
	
	public Product toProduct(ProductDTO productDTO) {
		return new Product(
				productDTO.getPid(),
				productDTO.getName(),
				productDTO.getDescription(),
				productDTO.getPrice(),
				productDTO.getStockQuantity(),
				productDTO.getCategory(),
				productDTO.getTags(),
				productDTO.getImageUrl(),
				productDTO.getRating(),
				productDTO.getRatingCount(),
				productDTO.getCreatedDate()
			);
	}
	
	public ProductDTO toProductDTO(Product product) {
		return new ProductDTO(
				product.getPid(),
				product.getName(),
				product.getDescription(),
				product.getPrice(),
				product.getStockQuantity(),
				product.getCategory(),
				product.getTags(),
				product.getImageUrl(),
				product.getRating(),
				product.getRatingcount(),
				product.getCreatedDate()
			);
		
	}

}
