package com.example.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cruddemo.model.Product;
import com.example.cruddemo.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Transactional
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	@Transactional
	public Optional<Product> findById(Long id) {

		return productRepository.findById(id);
	}
	
	@Transactional
	public Product save(Product product) {
		
		return productRepository.save(product);
	}
	
	@Transactional
	public void deleteByid(Long id) {
		
		productRepository.deleteById(id);
	}
}
