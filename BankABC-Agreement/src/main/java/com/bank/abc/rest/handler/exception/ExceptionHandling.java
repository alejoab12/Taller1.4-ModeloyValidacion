package com.bank.abc.rest.handler.exception;

import com.bank.abc.rest.model.ExceptionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler  {
	@ExceptionHandler(value = CustomerException.class)
	public ResponseEntity<ExceptionModel> exception(CustomerException exception) {
		return ResponseEntity.status(exception.getStatus()).body(new ExceptionModel(exception.getMessage()));
	}
}
