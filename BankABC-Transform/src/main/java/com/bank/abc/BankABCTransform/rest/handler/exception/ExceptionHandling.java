package com.bank.abc.BankABCTransform.rest.handler.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler  {
	@ExceptionHandler(value = CustomerException.class)
	public ResponseEntity<Void> exception(CustomerException exception) {
		return ResponseEntity.status(exception.getStatus()).build();
	}
}
