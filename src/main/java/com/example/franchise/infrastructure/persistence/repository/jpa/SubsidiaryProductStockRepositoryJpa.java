package com.example.franchise.infrastructure.persistence.repository.jpa;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.franchise.infrastructure.persistence.entity.SubsidiaryProductStockEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface SubsidiaryProductStockRepositoryJpa extends R2dbcRepository<SubsidiaryProductStockEntity, Integer> {

	Mono<Boolean> deleteByProductIdAndSubsidiaryId(Integer productId, Integer subsidiaryId);

	Mono<Boolean> existsByProductId(Integer productId);

	@Modifying
	@Query("""
			UPDATE SUBSIDIARY_PRODUCTS_STOCK
			SET QUANTITY = :stockQuantity
			WHERE PRODUCT_ID = :productId AND SUBSIDIARY_ID = :subsidiaryId
			""")
	Mono<Void> changeProductStockFromSubsidiary(@Param("productId") Integer productId,
			@Param("subsidiaryId") Integer subsidiaryId, @Param("stockQuantity") Integer stockQuantity);

	@Query("""
			SELECT SUBSIDIARY_ID, PRODUCT_ID, QUANTITY
			FROM SUBSIDIARY_PRODUCTS_STOCK SUPRST
			INNER JOIN 
			(
			SELECT SUBSIDIARY_ID, MAX(QUANTITY) QUANTITY
			FROM SUBSIDIARY_PRODUCTS_STOCK SUPRST
			INNER JOIN SUBSIDIARIES SU ON SUPRST.SUBSIDIARY_ID = SU.ID
			WHERE SU.FRANCHISE_ID = :franchiseId
			GROUP BY SUBSIDIARY_ID
			) MAXQ USING (SUBSIDIARY_ID, QUANTITY)
			""")
	Flux<SubsidiaryProductStockEntity> getProductsWithGreaterStock(@Param("franchiseId") Integer franchiseId);

}
