package com.technix.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.technix.entity.Product;

public interface ProductService {
	
	public Product createProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public Product getProductBYId(Long id);
	
	public ResponseEntity<?> updateProduct(Product product , Long id);
	
	public String deleteProduct(Long id);
	
	public ResponseEntity<?> getProductByCategory(String categoryName);
	
	
}
