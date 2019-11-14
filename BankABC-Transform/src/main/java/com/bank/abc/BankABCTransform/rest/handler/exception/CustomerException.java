package com.bank.abc.BankABCTransform.rest.handler.exception;

public class CustomerException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private int status;
	private String message;

	public CustomerException() {
		super();
	}

	public CustomerException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerException(String message) {
		super(message);
	}

	public CustomerException(Throwable cause, int status) {
		super(cause);
		this.status = status;
	}

	public CustomerException(int status, String message) {
		super(message);
		this.message = message;
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
