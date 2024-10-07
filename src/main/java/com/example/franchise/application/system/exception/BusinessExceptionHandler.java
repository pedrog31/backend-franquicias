package com.example.franchise.application.system.exception;

import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.franchise.domain.exception.BusinessException;
import com.example.franchise.domain.exception.Inconsistency;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BusinessExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public ResponseEntity<List<Inconsistency>> handleError(BusinessException en) {
		return ResponseEntity.badRequest().body(en.getInconsistencies());
	}
}
