package com.example.franchise.infrastructure.persistence.repository;

import org.springframework.stereotype.Repository;

import com.example.franchise.domain.model.Product;
import com.example.franchise.domain.repository.ProductRepository;
import com.example.franchise.infrastructure.persistence.entity.ProductEntity;
import com.example.franchise.infrastructure.persistence.mapper.ProductMapper;
import com.example.franchise.infrastructure.persistence.repository.jpa.ProductRepositoryJpa;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryRelational implements ProductRepository {
	
	private final ProductRepositoryJpa productRepositoryJpa;

	@Override
	public Mono<Product> createProduct(Product product) {
		ProductEntity entity = ProductMapper.toEntity(product);
		return productRepositoryJpa.save(entity)
				.map(ProductMapper::toDomain);
	}

	@Override
	public Mono<Void> deleteProduct(Integer id) {
		return productRepositoryJpa.deleteById(id);
	}

}
