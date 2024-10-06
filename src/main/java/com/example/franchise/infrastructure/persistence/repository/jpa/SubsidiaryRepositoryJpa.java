package com.example.franchise.infrastructure.persistence.repository.jpa;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.franchise.infrastructure.persistence.entity.SubsidiaryEntity;

import reactor.core.publisher.Mono;

@Repository
public interface SubsidiaryRepositoryJpa extends R2dbcRepository<SubsidiaryEntity, Integer> {

	@Modifying
	@Query("UPDATE SUBSIDIARIES SET NAME = :name WHERE ID = :id")
	Mono<Void> updateName(@Param("id") Integer id, @Param("name") String name);

}
