package com.instructor.db.relationship.mapper;

import com.instructor.db.relationship.dto.ProductDTO;
import com.instructor.db.relationship.model.Product;

public class ProductMapper {
	
	public static Product DtoToEntity(ProductDTO prd) {
		return new Product(prd.getName(),prd.getPrice());
	}
	
	public static ProductDTO EntityToDto(Product prd) {
		return new ProductDTO(prd.getName(),prd.getPrice());
	}
}
