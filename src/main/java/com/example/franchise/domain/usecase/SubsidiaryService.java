package com.example.franchise.domain.usecase;

import com.example.franchise.domain.model.Subsidiary;
import com.example.franchise.domain.repository.SubsidiaryRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SubsidiaryService {

	private final SubsidiaryRepository subsidiaryRepository;

	public Mono<Subsidiary> createSubsidiary(Subsidiary subsidiary, Integer franchiseId) {
		subsidiary.validate();
		return subsidiaryRepository.createSubsidiary(subsidiary, franchiseId);
	}

	public Mono<Void> changeSubsidiaryName(Subsidiary subsidiary) {
		subsidiary.validate();
		return subsidiaryRepository.changeSubsidiaryName(subsidiary);
	}

}
