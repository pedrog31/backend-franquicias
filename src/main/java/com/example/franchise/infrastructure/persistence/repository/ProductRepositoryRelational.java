package com.example.franchise.infrastructure.persistence.repository;

import org.springframework.stereotype.Repository;

import com.example.franchise.domain.model.Product;
import com.example.franchise.domain.repository.ProductRepository;
import com.example.franchise.domain.repository.SubsidiaryRepository;
import com.example.franchise.infrastructure.persistence.entity.ProductEntity;
import com.example.franchise.infrastructure.persistence.entity.SubsidiaryProductStockEntity;
import com.example.franchise.infrastructure.persistence.mapper.ProductMapper;
import com.example.franchise.infrastructure.persistence.mapper.SubsidiaryProductStockMapper;
import com.example.franchise.infrastructure.persistence.repository.jpa.ProductRepositoryJpa;
import com.example.franchise.infrastructure.persistence.repository.jpa.SubsidiaryProductStockRepositoryJpa;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryRelational implements ProductRepository {

	private final ProductRepositoryJpa productRepositoryJpa;
	private final SubsidiaryProductStockRepositoryJpa subsidiaryProductStockRepositoryJpa;
	private final SubsidiaryRepository subsidiaryRepository;

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
		return subsidiaryProductStockRepositoryJpa.deleteByProductIdAndSubsidiaryId(productId, subsidiaryId);
	}

	@Override
	public Mono<Boolean> existsSubsidiaryWithProduct(Integer productId) {
		return subsidiaryProductStockRepositoryJpa.existsByProductId(productId);
	}

	@Override
	public Mono<Void> changeProductStockFromSubsidiary(Product product) {
		return subsidiaryProductStockRepositoryJpa.changeProductStockFromSubsidiary(product.getId(),
				product.getSubsidiary().getId(), product.getStockQuantity());
	}

	@Override
	public Flux<Product> getProductsWithGreaterStock(Integer franchiseId) {
		return subsidiaryProductStockRepositoryJpa.getProductsWithGreaterStock(franchiseId)
				.flatMap(this::getProductWithSubsidiary);
	}

	private Mono<Product> getProductById(Integer id) {
		return productRepositoryJpa.findById(id).map(ProductMapper::toDomain);
	}

	private Mono<Product> getProductWithSubsidiary(SubsidiaryProductStockEntity entity) {
		return this.getProductById(entity.getProductId()).zipWith(subsidiaryRepository.getById(entity.getSubsidiaryId()))
				.map(tuple2 -> {
					var product = tuple2.getT1();
					product.setSubsidiary(tuple2.getT2());
					product.setStockQuantity(entity.getQuantity());
					return product;
				});
	}

}
