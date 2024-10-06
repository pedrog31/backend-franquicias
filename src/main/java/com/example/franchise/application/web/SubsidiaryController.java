package com.example.franchise.application.web;

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
	public Mono<Subsidiary> createSubsidiary(@RequestBody Subsidiary subsidiary, @RequestParam("subsidiaryId") Integer subsidiaryId) {
		return subsidiaryService.createSubsidiary(subsidiary, subsidiaryId);
	}
}
