package com.example.franchise.domain.repository;

import com.example.franchise.domain.model.Subsidiary;

import reactor.core.publisher.Mono;

public interface SubsidiaryRepository {

	Mono<Subsidiary> createSubsidiary(Subsidiary franchise, Integer franchiseId);

	Mono<Subsidiary> getById(Integer id);

}
