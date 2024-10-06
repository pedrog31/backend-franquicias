package com.example.franchise.domain.usecase;

import org.springframework.transaction.annotation.Transactional;

import com.example.franchise.domain.model.Product;
import com.example.franchise.domain.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public Mono<Product> createProduct(Product product) {
		return productRepository.createProduct(product);
	}

	public Mono<Void> deleteProduct(Integer id) {
		return productRepository.deleteProduct(id);
	}

	public Mono<Product> addProductToSubsidiary(Product product) {
		return productRepository.addProductToSubsidiary(product);
	}

	@Transactional(rollbackFor = {Exception.class, RuntimeException.class})
	public Mono<Void> deleteProductFromSubsidiary(Integer productId, Integer subsidiaryId) {
		return productRepository.deleteProductFromSubsidiary(productId, subsidiaryId);
	}

}
