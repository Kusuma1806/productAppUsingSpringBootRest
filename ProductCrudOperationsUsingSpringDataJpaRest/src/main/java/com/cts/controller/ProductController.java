package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.ProductNotFound;
import com.cts.model.Product;
import com.cts.service.ProductService;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/products") // http://localhost:8080/products
@NoArgsConstructor
public class ProductController {
	@Autowired
	ProductService service;

	@GetMapping("/getMsg") // http://localhost:8080/products/getMsg
	public String sayHello() {
		return "hellooooooooooooooo am trying to listen but am getting sleep";
	}

	@PostMapping("/saveproduct") // http://localhost:8080/products/saveproduct
	public String insertProduct(@RequestBody @Validated Product product) {
		return service.saveProduct(product);
	}

	@PutMapping("/updateproduct") // http://localhost:8080/products/saveproduct
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	@GetMapping("/getproduct/{pid}") // http://localhost:8080/products/getMsg
	public Product getProduct(@PathVariable("pid") int productId) throws ProductNotFound {
		return service.getProduct(productId);
	}
	@DeleteMapping("/deleteproduct/{pid}") // http://localhost:8080/products/getMsg
	public String removeProduct(@PathVariable("pid") int productId) {
		return service.removeProduct(productId);
	}
	@GetMapping("/getproducts") // http://localhost:8080/products/getMsg
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}
	@GetMapping("/getproductsbetweenprice/{fsp}/{ssp}") // http://localhost:1111/products/getMsg
	public List<Product> getAllProductsBetweeen(@PathVariable("fsp") int intialPrice,@PathVariable("ssp") int finalPrice) {
		return service.getAllProductsBetween(intialPrice,finalPrice);
	}
	@GetMapping("/getproductgreaterthanprice/{price}") // http://localhost:8080/products/getMsg
	public List<Product> getAllProductsGreater(@PathVariable("price") int productPrice) {
		return service.getAllProductsGreater(productPrice);
	}
	@GetMapping("/getproductsbycategory/{category}") // http://localhost:8080/products/getMsg
	public List<Product> getAllProductsGreater(@PathVariable("category") String productCategory) {
		return service.getAllProductsByCategory(productCategory);
	}
//	@ExceptionHandler(exception = ProductNotFound.class,produces = "Product Id Is Invalid")
//	public void handleProductNotFound()
//	{
//		
//	}
}
