package com.example.franchise.infrastructure.persistence.repository.jpa;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.franchise.infrastructure.persistence.entity.FranchiseEntity;

import reactor.core.publisher.Mono;

@Repository
public interface FranchiseRepositoryJpa extends R2dbcRepository<FranchiseEntity, Integer> {


	@Modifying
	@Query("UPDATE FRANCHISES SET NAME = :name WHERE ID = :id")
	Mono<Void> updateName(@Param("id") Integer id, @Param("name") String name);

}
