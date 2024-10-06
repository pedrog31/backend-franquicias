package com.example.franchise.infrastructure.persistence.mapper;

import com.example.franchise.domain.model.Franchise;
import com.example.franchise.infrastructure.persistence.entity.FranchiseEntity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FranchiseMapper {

	public static FranchiseEntity toEntity(Franchise franchise) {
		return FranchiseEntity.builder()
				.id(franchise.getId())
				.name(franchise.getName())
				.build();
	}

	public static Franchise toDomain(FranchiseEntity franchiseEntity) {
		return Franchise.builder()
				.id(franchiseEntity.getId())
				.name(franchiseEntity.getName())
				.build();
	}

}
