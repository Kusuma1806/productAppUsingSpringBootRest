package com.cts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "products_info")
public class Product {
	@Id
	@Column(name = "pid")
	@GeneratedValue
	private int productId;
	@NotBlank(message = "Product name can't be NULL or BLANK")
	private String productName;
	@Min(value = 100, message = "Price should be greater than 100")
	@Max(value = 100000, message = "Price should be less than 1L")
	@Column(name = "price")
	private int productPrice;
	@Size(min = 3, max = 12, message = "Category length must be between(3,12)")
	private String productCategory;
	@Column(name = "quantity")
	@Positive(message="Product quantity cannot be 0 or -ve")
	private int productQuantity;

	public Product() {
		System.out.println("Default Constructor of Product");
	}

	public Product(String productName, int productPrice, String productCategory, int productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

}
