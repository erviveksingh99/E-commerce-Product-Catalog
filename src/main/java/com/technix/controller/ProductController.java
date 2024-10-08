package com.technix.controller;

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
import org.springframework.web.bind.annotation.RestController;
import com.technix.entity.Product;
import com.technix.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/products")
	public Product createProduct(@Valid @RequestBody Product product)
	{
		return productService.createProduct(product);
		
	}
	
	@GetMapping("/products")
	//@RequestMapping(produces = {"application/json", "application/xml"})
	public List<Product> getAllProduct()
	{
		return productService.getAllProduct();	
	}

	@GetMapping("/products/{id}")
	public Product getProductBYId(@PathVariable("id") Long id)
	{
		return productService.getProductBYId(id);
	}
	
	@PutMapping("/products/{uid}")
	public ResponseEntity<?> updateProduct(@Valid @RequestBody Product product, @PathVariable("uid") Long uid)
	{
		return productService.updateProduct(product,uid);
		
	}
	
	@DeleteMapping("/products/{did}")
	public String deleteProduct(@PathVariable Long did)
	{
		return productService.deleteProduct(did);	
	}
	
	@GetMapping("/category/{categoryName}")
	public ResponseEntity<?> getProductByCategory(@PathVariable String categoryName)
	{
		return productService.getProductByCategory(categoryName);
	}	
}
