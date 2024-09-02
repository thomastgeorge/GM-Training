package com.graymatter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.graymatter.dto.ProductDTO;
import com.graymatter.services.ProductService;


@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/admin/add/product")
	public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
		return productService.addProduct(productDTO);
	}

	@GetMapping("/user/product/all")
	public List<ProductDTO> getAllProduct() {
		return productService.getAllProduct();
		
	}

	@GetMapping("/user/product")
	public ProductDTO getProductById(@RequestParam("pid") int pid) {
		return productService.getProductById(pid);
	}

	@PutMapping("/user/product/update")
	public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
		return productService.updateProduct(productDTO);
	}

	@DeleteMapping("/admin/delete")
	public void deleteProduct(@RequestParam("pid") int pid) {
		productService.deleteProduct(pid);
	}

	@GetMapping("/user/product/search")
	public List<ProductDTO> search(@RequestParam String tag,@RequestParam String name,@RequestParam String category,@RequestParam Double minPrice,@RequestParam Double maxPrice) {
		return productService.search(tag, name, category, minPrice, maxPrice);
		
	}
	
}
