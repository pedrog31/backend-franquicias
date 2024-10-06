package com.example.franchise.infrastructure.persistence.mapper;

import com.example.franchise.domain.model.Product;
import com.example.franchise.infrastructure.persistence.entity.SubsidiaryProductStockEntity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SubsidiaryProductStockMapper {

	public static SubsidiaryProductStockEntity toEntity(Product product) {
		return SubsidiaryProductStockEntity.builder().productId(product.getId())
				.subsidiaryId(product.getSubsidiary().getId()).quantity(product.getStockQuantity()).build();
	}

}
