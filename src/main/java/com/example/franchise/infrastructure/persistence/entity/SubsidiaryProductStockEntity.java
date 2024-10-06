package com.example.franchise.infrastructure.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SUBSIDIARY_PRODUCTS_STOCK")
public class SubsidiaryProductStockEntity {

	@Id
	private Integer id;

	private Integer subsidiaryId;

	private Integer productId;

	private Integer quantity;

}
