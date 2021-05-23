package com.instructor.db.relationship.service;

import java.util.List;
import java.util.Optional;

import com.instructor.db.relationship.model.Product;

public interface Iproduct {
	
	List<Product> getAllProducts();
	Optional<Product> findById(int id);
	Product save(Product prd);
	Optional<Product> findByProductName(String productName);
}
