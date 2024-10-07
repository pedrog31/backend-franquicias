package com.example.franchise.domain.usecase;

import org.springframework.transaction.annotation.Transactional;

import com.example.franchise.domain.model.Product;
import com.example.franchise.domain.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	public Mono<Product> createProduct(Product product) {
		product.validateProductToCreate();
		return productRepository.createProduct(product);
	}

	public Mono<Void> deleteProduct(Integer id) {
		return productRepository.deleteProduct(id);
	}

	public Mono<Product> addProductToSubsidiary(Product product) {
		product.validateAddProductToSubsidiary();
		return productRepository.addProductToSubsidiary(product);
	}

	@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
	public Mono<Void> deleteProductFromSubsidiary(Integer productId, Integer subsidiaryId) {
		return productRepository.deleteProductFromSubsidiary(productId, subsidiaryId)
				.flatMap(v -> this.deleteProductIfDontHaveAnySubsidiary(productId));
	}

	private Mono<Void> deleteProductIfDontHaveAnySubsidiary(Integer productId) {
		return productRepository.existsSubsidiaryWithProduct(productId)
				.flatMap(exists -> Boolean.TRUE.equals(exists) ? Mono.empty() : this.deleteProduct(productId));
	}

	public Mono<Void> changeProductStockFromSubsidiary(Product product) {
		return productRepository.changeProductStockFromSubsidiary(product);
	}

	public Flux<Product> getProductsWithGreaterStock(Integer franchiseId) {
		return productRepository.getProductsWithGreaterStock(franchiseId);
	}

	public Mono<Void> changeProductName(Product product) {
		return productRepository.changeProductName(product);
	}

}
