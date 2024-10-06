package com.example.franchise.infrastructure.persistence.repository.jpa;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.example.franchise.infrastructure.persistence.entity.SubsidiaryProductStockEntity;

import reactor.core.publisher.Mono;

@Repository
public interface SubsidiaryProductStockRepositoryJpa extends R2dbcRepository<SubsidiaryProductStockEntity, Integer> {

	Mono<Void> deleteByProductIdAndSubsidiaryId(Integer productId, Integer subsidiaryId);

	Mono<Boolean> existsByProductId(Integer productId);
	

}
