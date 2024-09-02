package com.graymatter.services;

import java.util.List;

import com.graymatter.dto.ProductDTO;

public interface ProductServiceInterface {
	
	public ProductDTO addProduct(ProductDTO productDTO);
	
	public List<ProductDTO> getAllProduct();
	
	public ProductDTO getProductById(int pid);
	
	public ProductDTO updateProduct(ProductDTO productDTO);
	
	public void deleteProduct(int pid);
	
	public List<ProductDTO> search(String tag, String name, String category, Double minPrice, Double maxPrice);

}
