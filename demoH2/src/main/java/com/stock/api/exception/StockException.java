package com.stock.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StockException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public StockException(String message) {
		super(message);
	}
	
	public StockException(String message, Throwable t) {
		super(message, t);
	}
}
