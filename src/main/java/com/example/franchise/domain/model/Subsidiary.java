package com.example.franchise.domain.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.example.franchise.domain.constans.FranchiseInconsistencyEnum;
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
public class Subsidiary {

	private Integer id;

	private String name;

	@JsonIgnore
	protected final List<Inconsistency> inconsistencies = new ArrayList<>();

	public void validate() {
		this.validateName();
		if (!inconsistencies.isEmpty()) {
			throw new BusinessException(inconsistencies);
		}
	}

	private void validateName() {
		if (StringUtils.isAllBlank(name) || name.length() > 100) {
			inconsistencies.add(FranchiseInconsistencyEnum.NAME.build());
		}
	}
}
