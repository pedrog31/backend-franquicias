package com.example.franchise.domain.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.example.franchise.domain.constans.ProductInconsistencyEnum;
import com.example.franchise.domain.exception.BusinessException;
import com.example.franchise.domain.exception.Inconsistency;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Product {

	private Integer id;

	private String name;

	private Integer stockQuantity;

	private Subsidiary subsidiary;

	@JsonIgnore
	protected final List<Inconsistency> inconsistencies = new ArrayList<>();

	public void validateProductToCreate() {
		id = null;
		this.validateName();
		if (!inconsistencies.isEmpty()) {
			throw new BusinessException(inconsistencies);
		}
	}

	private void validateName() {
		if (StringUtils.isAllBlank(name) || name.length() > 100) {
			inconsistencies.add(ProductInconsistencyEnum.NAME.build());
		}
	}

	public void validateAddProductToSubsidiary() {
		this.validateStockQuantity();
		this.validateId();
		this.validateSubsidiary();
		if (!inconsistencies.isEmpty()) {
			throw new BusinessException(inconsistencies);
		}
	}

	private void validateId() {
		if (id == null) {
			inconsistencies.add(ProductInconsistencyEnum.ID.build());
		}
	}

	private void validateSubsidiary() {
		if (subsidiary == null || subsidiary.getId() == null) {
			inconsistencies.add(ProductInconsistencyEnum.SUBSIDIARY_ID.build());
		}
	}

	private void validateStockQuantity() {
		if (stockQuantity == null || stockQuantity < 0) {
			inconsistencies.add(ProductInconsistencyEnum.STOCK_QUANTITY.build());
		}
	}

}
