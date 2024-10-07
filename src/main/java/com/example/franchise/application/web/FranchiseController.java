package com.example.franchise.application.web;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.franchise.domain.model.Franchise;
import com.example.franchise.domain.usecase.FranchiseService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/franchise")
@RequiredArgsConstructor
public class FranchiseController {

	private final FranchiseService franchiseService;

	@PostMapping
	@Operation(summary = "2. Agregar una nueva franquicia.", description = "Se envia solo el atributo name en el body")
	public Mono<Franchise> createFranchise(@RequestBody Franchise franchise) {
		return franchiseService.createFranchise(franchise);
	}

	@PatchMapping("/name")
	@Operation(summary = "Pe3. actualizar el nombre de una franquicia", description = "Se envia el atributo id y name en el body")
	public Mono<Void> changeFranchiseName(@RequestBody Franchise franchise) {
		return franchiseService.changeFranchiseName(franchise);
	}
}
