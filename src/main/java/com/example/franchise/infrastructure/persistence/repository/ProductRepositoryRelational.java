package com.example.franchise.infrastructure.persistence.repository;

import org.springframework.stereotype.Repository;

import com.example.franchise.domain.model.Product;
import com.example.franchise.domain.repository.ProductRepository;
import com.example.franchise.infrastructure.persistence.entity.ProductEntity;
import com.example.franchise.infrastructure.persistence.entity.SubsidiaryProductStockEntity;
import com.example.franchise.infrastructure.persistence.mapper.ProductMapper;
import com.example.franchise.infrastructure.persistence.mapper.SubsidiaryProductStockMapper;
import com.example.franchise.infrastructure.persistence.repository.jpa.ProductRepositoryJpa;
import com.example.franchise.infrastructure.persistence.repository.jpa.SubsidiaryProductStockRepositoryJpa;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryRelational implements ProductRepository {

	private final ProductRepositoryJpa productRepositoryJpa;
	private final SubsidiaryProductStockRepositoryJpa subsidiaryProductStockRepositoryJpa;

	@Override
	public Mono<Product> createProduct(Product product) {
		ProductEntity entity = ProductMapper.toEntity(product);
		return productRepositoryJpa.save(entity).map(ProductMapper::toDomain);
	}

	@Override
	public Mono<Void> deleteProduct(Integer id) {
		return productRepositoryJpa.deleteById(id);
	}

	@Override
	public Mono<Product> addProductToSubsidiary(Product product) {
		SubsidiaryProductStockEntity entity = SubsidiaryProductStockMapper.toEntity(product);
		return subsidiaryProductStockRepositoryJpa.save(entity).map(ent -> product);
	}

	@Override
	public Mono<Boolean> deleteProductFromSubsidiary(Integer productId, Integer subsidiaryId) {
		return subsidiaryProductStockRepositoryJpa.deleteByProductIdAndSubsidiaryId(productId, subsidiaryId).thenReturn(true);
	}

	@Override
	public Mono<Boolean> existsSubsidiaryWithProduct(Integer productId) {
		return subsidiaryProductStockRepositoryJpa.existsByProductId(productId);
	}

}
