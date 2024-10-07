package com.example.franchise.domain.constans;

import com.example.franchise.domain.exception.Inconsistency;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SubsidiaryInconsistencyEnum {

	NAME("SU01", "El nombre debe tener menos de 100 caracteres.", "Nombre"),
	;

	private final String code;
	private final String message;
	private final String type;

	public Inconsistency build() {
		return new Inconsistency(type, code, message);
	}
}
