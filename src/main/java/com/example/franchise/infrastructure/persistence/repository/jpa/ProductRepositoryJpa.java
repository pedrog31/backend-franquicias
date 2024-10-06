package com.example.franchise.infrastructure.persistence.repository.jpa;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.franchise.infrastructure.persistence.entity.ProductEntity;

import reactor.core.publisher.Mono;

@Repository
public interface ProductRepositoryJpa extends R2dbcRepository<ProductEntity, Integer> {

	@Modifying
	@Query("UPDATE PRODUCTS SET NAME = :name WHERE ID = :id")
	Mono<Void> updateName(@Param("id") Integer id, @Param("name") String name);

}
