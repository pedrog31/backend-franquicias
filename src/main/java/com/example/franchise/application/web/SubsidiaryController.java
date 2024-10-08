package com.example.franchise.application.web;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.franchise.domain.model.Subsidiary;
import com.example.franchise.domain.usecase.SubsidiaryService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/subsidiary")
@RequiredArgsConstructor
public class SubsidiaryController {

	private final SubsidiaryService subsidiaryService;

	@PostMapping
	public Mono<Subsidiary> createSubsidiary(@RequestBody Subsidiary subsidiary,
			@RequestParam("franchiseId") Integer franchiseId) {
		return subsidiaryService.createSubsidiary(subsidiary, franchiseId);
	}

	@PatchMapping("/name")
	public Mono<Void> changeSubsidiaryName(@RequestBody Subsidiary subsidiary) {
		return subsidiaryService.changeSubsidiaryName(subsidiary);
	}
}
