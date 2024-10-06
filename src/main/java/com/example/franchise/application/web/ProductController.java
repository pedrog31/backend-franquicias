package com.example.franchise.application.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.franchise.domain.model.Product;
import com.example.franchise.domain.usecase.ProductService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;

	@PostMapping
	public Mono<Product> createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> deleteProduct(@PathVariable("id") Integer id) {
		return productService.deleteProduct(id);
	}
}
