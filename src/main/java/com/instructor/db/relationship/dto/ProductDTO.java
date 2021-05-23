package com.instructor.db.relationship.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ProductDTO {

	@NotBlank(message = "Name is required!")
	private String name;
	
	@NotNull
	@Min(value = 20)
	@Positive(message = "Price cannot be Zero or negative")
	private int price;

	
	
	public ProductDTO(@NotBlank(message = "Name is required!") String name,
			@NotNull @Min(20) @Positive(message = "Price cannot be Zero or negative") int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
