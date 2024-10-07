package com.example.franchise.domain.usecase;

import com.example.franchise.domain.model.Franchise;
import com.example.franchise.domain.repository.FranchiseRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FranchiseService {

	private final FranchiseRepository franchiseRepository;

	public Mono<Franchise> createFranchise(Franchise franchise) {
		franchise.validate();
		return franchiseRepository.createFranchise(franchise);
	}

	public Mono<Void> changeFranchiseName(Franchise franchise) {
		franchise.validate();
		return franchiseRepository.changeFranchiseName(franchise);
	}

}
