package com.example.franchise.infrastructure.persistence.repository;

import org.springframework.stereotype.Repository;

import com.example.franchise.domain.model.Subsidiary;
import com.example.franchise.domain.repository.SubsidiaryRepository;
import com.example.franchise.infrastructure.persistence.entity.SubsidiaryEntity;
import com.example.franchise.infrastructure.persistence.mapper.SubsidiaryMapper;
import com.example.franchise.infrastructure.persistence.repository.jpa.SubsidiaryRepositoryJpa;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class SubsidiaryRepositoryRelational implements SubsidiaryRepository {
	
	private final SubsidiaryRepositoryJpa subsidiaryRepositoryJpa;

	@Override
	public Mono<Subsidiary> createSubsidiary(Subsidiary subsidiary, Integer franchiseId) {
		SubsidiaryEntity entity = SubsidiaryMapper.toEntity(subsidiary, franchiseId);
		return subsidiaryRepositoryJpa.save(entity)
				.map(SubsidiaryMapper::toDomain);
	}

}
