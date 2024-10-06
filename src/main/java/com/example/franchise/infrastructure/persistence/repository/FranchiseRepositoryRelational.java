package com.example.franchise.infrastructure.persistence.repository;

import org.springframework.stereotype.Repository;

import com.example.franchise.domain.model.Franchise;
import com.example.franchise.domain.repository.FranchiseRepository;
import com.example.franchise.infrastructure.persistence.entity.FranchiseEntity;
import com.example.franchise.infrastructure.persistence.mapper.FranchiseMapper;
import com.example.franchise.infrastructure.persistence.repository.jpa.FranchiseRepositoryJpa;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class FranchiseRepositoryRelational implements FranchiseRepository {

	private final FranchiseRepositoryJpa franchiseRepositoryJpa;

	@Override
	public Mono<Franchise> createFranchise(Franchise franchise) {
		FranchiseEntity entity = FranchiseMapper.toEntity(franchise);
		return franchiseRepositoryJpa.save(entity).map(FranchiseMapper::toDomain);
	}

	@Override
	public Mono<Void> changeFranchiseName(Franchise franchise) {
		return franchiseRepositoryJpa.updateName(franchise.getId(), franchise.getName());
	}

}
