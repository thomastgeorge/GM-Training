package com.graymatter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.graymatter.entities.Product;
import com.graymatter.repositories.ProductRepository;

@Repository
public class ProductDao {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	public Product getProductById(int pid) {
		return productRepository.findById(pid).get();
	}
	
	public Product updateProduct(Product product) {
		Product tempProduct = getProductById(product.getPid());
		if(tempProduct==null)
			return null;
		return productRepository.save(product);
	}
	
	public void deleteProduct(int pid) {
		productRepository.deleteById(pid);
	}
	
	public List<Product> search(String tag, String name, String category, Double minPrice, Double maxPrice){
		return productRepository.search(tag, name, category, minPrice, maxPrice);
	}

}
