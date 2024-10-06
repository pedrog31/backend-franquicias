package com.example.franchise.infrastructure.persistence.mapper;

import com.example.franchise.domain.model.Product;
import com.example.franchise.infrastructure.persistence.entity.ProductEntity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductMapper {

	public static ProductEntity toEntity(Product product) {
		return ProductEntity.builder()
				.id(product.getId())
				.name(product.getName())
				.build();
	}

	public static Product toDomain(ProductEntity productEntity) {
		return Product.builder()
				.id(productEntity.getId())
				.name(productEntity.getName())
				.build();
	}

}
