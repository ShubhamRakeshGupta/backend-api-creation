package com.example.cruddemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cruddemo.model.Product;
import com.example.cruddemo.service.ProductService;

@RestController
@RequestMapping("/Products") 
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@GetMapping
	public List<Product> getAllProduct(){
		return productService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		Optional<Product> product = productService.findById(id);
		return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Product>createProduct(@RequestBody Product product){
		Product createdProduct = productService.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateproduct(@PathVariable Long id, @RequestBody Product product){
		
		if(!productService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		product.setId(id);
		Product updatedProduct = productService.save(product);
		return ResponseEntity.ok(updatedProduct);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
		
		if(!productService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		productService.deleteByid(id);
		System.out.println("Product deleted Successfully");
		return ResponseEntity.noContent().build();
	}
	
}

