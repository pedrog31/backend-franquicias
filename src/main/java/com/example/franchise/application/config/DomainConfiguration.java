package com.example.franchise.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.franchise.domain.repository.FranchiseRepository;
import com.example.franchise.domain.repository.ProductRepository;
import com.example.franchise.domain.repository.SubsidiaryRepository;
import com.example.franchise.domain.usecase.FranchiseService;
import com.example.franchise.domain.usecase.ProductService;
import com.example.franchise.domain.usecase.SubsidiaryService;

@Configuration
public class DomainConfiguration {
	
	@Bean
	FranchiseService franchiseService(FranchiseRepository franchiseRepository) {
        return new FranchiseService(franchiseRepository);
    }
	
	@Bean
	SubsidiaryService subsidiaryService(SubsidiaryRepository subsidiaryRepository) {
        return new SubsidiaryService(subsidiaryRepository);
    }
	
	@Bean
	ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }

}
