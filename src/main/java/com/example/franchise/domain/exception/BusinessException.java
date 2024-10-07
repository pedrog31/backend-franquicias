package com.example.franchise.domain.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = -1766777614223287725L;

	private final List<Inconsistency> inconsistencies;

	public BusinessException(List<Inconsistency> inconsistencies) {
		super(inconsistencies.stream().map(Inconsistency::toString)
				.collect(Collectors.joining(",")));
		this.inconsistencies = inconsistencies;
	}

	public BusinessException(Inconsistency inconsistency) {
		super(inconsistency.toString());
		this.inconsistencies = new ArrayList<>();
		this.inconsistencies.add(inconsistency);
	}

	public List<Inconsistency> getInconsistencies() {
		return inconsistencies;
	}

}
