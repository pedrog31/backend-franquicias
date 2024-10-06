package com.example.franchise.domain.repository;

import com.example.franchise.domain.model.Product;

import reactor.core.publisher.Mono;

public interface ProductRepository {
	
	Mono<Product> createProduct(Product franchise);

	Mono<Void> deleteProduct(Integer id);

	Mono<Product> addProductToSubsidiary(Product product);

	Mono<Void> deleteProductFromSubsidiary(Integer productId, Integer subsidiaryId);

}
