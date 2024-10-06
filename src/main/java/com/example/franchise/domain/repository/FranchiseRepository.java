package com.example.franchise.domain.repository;

import com.example.franchise.domain.model.Franchise;

import reactor.core.publisher.Mono;

public interface FranchiseRepository {

	Mono<Franchise> createFranchise(Franchise franchise);

	Mono<Void> changeFranchiseName(Franchise franchise);

}
