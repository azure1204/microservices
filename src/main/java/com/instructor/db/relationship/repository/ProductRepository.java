package com.instructor.db.relationship.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.instructor.db.relationship.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	public Optional<Product> findByName(String productName);
}
