package com.example.franchise.application.web;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.franchise.domain.model.Subsidiary;
import com.example.franchise.domain.usecase.SubsidiaryService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/subsidiary")
@RequiredArgsConstructor
public class SubsidiaryController {

	private final SubsidiaryService subsidiaryService;

	@PostMapping
	@Operation(summary = "3. Agregar una nueva sucursal a una franquicia.", description = "Se envia solo el atributo name en el body y el id de la franquicia como parametro")
	public Mono<Subsidiary> createSubsidiary(@RequestBody Subsidiary subsidiary,
			@RequestParam("franchiseId") Integer franchiseId) {
		return subsidiaryService.createSubsidiary(subsidiary, franchiseId);
	}

	@PatchMapping("/name")
	@Operation(summary = "Pe4. actualizar el nombre de una sucursal", description = "Se envia el atributo id y name en el body")
	public Mono<Void> changeSubsidiaryName(@RequestBody Subsidiary subsidiary) {
		return subsidiaryService.changeSubsidiaryName(subsidiary);
	}
}
