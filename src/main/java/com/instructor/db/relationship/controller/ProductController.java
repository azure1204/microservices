package com.instructor.db.relationship.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.instructor.db.relationship.dto.ProductDTO;
import com.instructor.db.relationship.exception.ProductNotFoundException;
import com.instructor.db.relationship.mapper.ProductMapper;
import com.instructor.db.relationship.model.Product;
import com.instructor.db.relationship.service.ProductService;


@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value="/products")
	List<Product> getAll(){
		return productService.getAllProducts();
	}
	
	@GetMapping(value="/products/{id}")
	ResponseEntity<Product> getById(@PathVariable("id") @Min(1) int id) {
		
		Product prd = productService.findById(id)
				                    .orElseThrow(()->new ProductNotFoundException("No Product with ID : "+id));
		 
		return ResponseEntity.ok().body(prd);
	}
	
	@GetMapping(value="/products_name/{name}")
	ResponseEntity<?> getByName(@PathVariable("name")  String productName) {
		
		Product prd = productService.findByProductName(productName)
				                    .orElseThrow(()->new ProductNotFoundException("No Product with productName : "+productName));
		 
		return ResponseEntity.ok().body(prd.getPrice());
	}
	
	
	@PostMapping(value="/products")
	ResponseEntity<?> createProduct(@Valid @RequestBody ProductDTO inprod) {
		Product prd      = ProductMapper.DtoToEntity(inprod);
		Product addedprd = productService.save(prd);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
						                .path("/{id}")
						                .buildAndExpand(addedprd.getId())
						                .toUri();
		return ResponseEntity.created(location).build();
	}
}
