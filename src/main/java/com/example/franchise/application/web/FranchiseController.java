package com.example.franchise.application.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.franchise.domain.model.Franchise;
import com.example.franchise.domain.usecase.FranchiseService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/franchise")
@RequiredArgsConstructor
public class FranchiseController {
	
	private final FranchiseService franchiseService;

	@PostMapping
	public Mono<Franchise> createFranchise(@RequestBody Franchise franchise) {
		return franchiseService.createFranchise(franchise);
	}
}
