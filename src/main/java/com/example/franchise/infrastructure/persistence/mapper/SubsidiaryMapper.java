package com.example.franchise.infrastructure.persistence.mapper;

import com.example.franchise.domain.model.Subsidiary;
import com.example.franchise.infrastructure.persistence.entity.SubsidiaryEntity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SubsidiaryMapper {

	public static SubsidiaryEntity toEntity(Subsidiary subsidiary, Integer franchiseId) {
		return SubsidiaryEntity.builder()
				.id(subsidiary.getId())
				.name(subsidiary.getName())
				.franchiseId(franchiseId)
				.build();
	}

	public static Subsidiary toDomain(SubsidiaryEntity subsidiaryEntity) {
		return Subsidiary.builder()
				.id(subsidiaryEntity.getId())
				.name(subsidiaryEntity.getName())
				.build();
	}

}
