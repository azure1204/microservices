package com.instructor.db.relationship.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instructor.db.relationship.model.Product;
import com.instructor.db.relationship.repository.ProductRepository;

@Service
public class ProductService implements Iproduct {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	
	@Override
	public Optional<Product> findByProductName(String productName) {
		// TODO Auto-generated method stub
		return this.productRepository.findByName(productName);
	}


	@Override
	public Optional<Product> findById(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public Product save(Product prd) {
		// TODO Auto-generated method stub
		return productRepository.save(prd);
	}

	

}
