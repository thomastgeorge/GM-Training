package com.graymatter.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graymatter.dao.ProductDao;
import com.graymatter.dto.ProductDTO;
import com.graymatter.dto.ProductMapper;
import com.graymatter.entities.Product;

@Service
public class ProductService implements ProductServiceInterface {

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public ProductDTO addProduct(ProductDTO productDTO) {
		return productMapper.toProductDTO(productDao.addProduct(productMapper.toProduct(productDTO)));
	}

	@Override
	public List<ProductDTO> getAllProduct() {
		List<Product> pList = productDao.getAllProduct();
		return pList.stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList()
            );
	}

	@Override
	public ProductDTO getProductById(int pid) {
		return productMapper.toProductDTO(productDao.getProductById(pid));
	}

	@Override
	public ProductDTO updateProduct(ProductDTO productDTO) {
		return productMapper.toProductDTO(productDao.updateProduct(productMapper.toProduct(productDTO)));
	}

	@Override
	public void deleteProduct(int pid) {
		productDao.deleteProduct(pid);
	}

	@Override
	public List<ProductDTO> search(String tag, String name, String category, Double minPrice, Double maxPrice) {
		List<Product> pList = productDao.search(tag, name, category, minPrice, maxPrice);
		return pList.stream()
                .map(productMapper::toProductDTO)
                .collect(Collectors.toList()
            );
	}

}
