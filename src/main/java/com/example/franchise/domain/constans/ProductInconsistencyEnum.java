package com.example.franchise.domain.constans;

import com.example.franchise.domain.exception.Inconsistency;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductInconsistencyEnum {

	NAME("PR01", "El nombre debe tener menos de 100 caracteres.", "Nombre"),
	STOCK_QUANTITY("PR02", "En Stock no puede ser negativo.", "Stock"),
	ID("PR03", "El id del producto es requerido.", "Id"),
	SUBSIDIARY_ID("PR04", "La sucursal es requerida.", "Sucursal"),
	;

	private final String code;
	private final String message;
	private final String type;

	public Inconsistency build() {
		return new Inconsistency(type, code, message);
	}
}
