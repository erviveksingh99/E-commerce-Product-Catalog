package com.technix.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.technix.custome.IdNotFoundException;
import com.technix.entity.Product;
import com.technix.repository.ProductRepository;

import jakarta.validation.Valid;

@Service
@Validated
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public Product createProduct(@Valid Product product) {
		LocalDateTime currentDateTime = LocalDateTime.now();
		product.setCreatedAt(currentDateTime);
		// Basically if we will not add updated date time then i will store in as a null
		// value in database
		// That's why i used current date time but when we want to update the product
		// then i will store updated date and time.
		product.setUpdatedAt(currentDateTime);
		return productRepo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductBYId(Long id) {

		return productRepo.findById(id)
				.orElseThrow(() -> new IdNotFoundException("Product with id " + id + " not found."));
	}

	@Override
	public ResponseEntity<?> updateProduct(@Valid Product product, Long id) {
		Optional<Product> findById = productRepo.findById(id);
		if (findById.isPresent()) {
			LocalDateTime updateDateTime = LocalDateTime.now();
			Product product2 = findById.get();
			product.setCreatedAt(product2.getCreatedAt());
			product.setUpdatedAt(updateDateTime);
			productRepo.save(product);
			return new ResponseEntity<>("Data Updated", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Product with id " + id + " not found.", HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<?> getProductByCategory(String categoryName) {

		List<Product> findByCategory = productRepo.findByCategory(categoryName);
		if (findByCategory != null) {
			return new ResponseEntity<>(findByCategory, HttpStatus.OK);
		} else {
			String str = "Product with Category " + categoryName + " not found.";
			return new ResponseEntity<>(str, HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public String deleteProduct(Long id) {
		Optional<Product> findById = productRepo.findById(id);
		if (findById.isPresent()) {
			productRepo.deleteById(id);
			return "Product is deleted";
		} else {
			return "Product with id " + id + " not found.";
		}

	}

}
