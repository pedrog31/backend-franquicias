package com.example.franchise.infrastructure.persistence.repository.jpa;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.example.franchise.infrastructure.persistence.entity.SubsidiaryEntity;

@Repository
public interface SubsidiaryRepositoryJpa extends R2dbcRepository<SubsidiaryEntity, Integer> {
	

}
