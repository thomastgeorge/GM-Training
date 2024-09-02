package com.graymatter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.graymatter.dto.ProductDTO;
import com.graymatter.exception.InvalidQueryException;
import com.graymatter.exception.ProductIdNotFoundException;
import com.graymatter.services.ProductService;


@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/admin/add/product")
	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
		ProductDTO pDTO = productService.addProduct(productDTO);
		return ResponseEntity.ok(pDTO);
	}

	@GetMapping("/user/product/all")
	public ResponseEntity<List<ProductDTO>> getAllProduct() {
		List<ProductDTO> plist = productService.getAllProduct();
		return ResponseEntity.ok(plist);
		
	}

	@GetMapping("/user/product")
	public ResponseEntity<ProductDTO> getProductById(@RequestParam("pid") int pid) throws ProductIdNotFoundException {
		ProductDTO pDTO = productService.getProductById(pid);
		return ResponseEntity.ok(pDTO);
	}

	@PutMapping("/user/update/product")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
		ProductDTO pDTO = productService.updateProduct(productDTO);
		return ResponseEntity.ok(pDTO);
	}

	@DeleteMapping("/admin/delete/product/{pid}")
	public void deleteProduct(@PathVariable("pid") int pid) throws ProductIdNotFoundException {
		productService.deleteProduct(pid);
	}

	@GetMapping("/user/product/search")
	public List<ProductDTO> search(
		    @RequestParam(required = false) String tag,
		    @RequestParam(required = false) String name,
		    @RequestParam(required = false) String category,
		    @RequestParam(required = false) Double minPrice,
		    @RequestParam(required = false) Double maxPrice
		) throws InvalidQueryException {
		return productService.search(tag, name, category, minPrice, maxPrice);
		
	}
	
}
