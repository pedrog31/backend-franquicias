package com.example.franchise.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.franchise.domain.repository.FranchiseRepository;
import com.example.franchise.domain.usecase.FranchiseService;

@Configuration
public class DomainConfiguration {
	
	@Bean
	FranchiseService insuredService(FranchiseRepository franchiseRepository) {
        return new FranchiseService(franchiseRepository);
    }

}
