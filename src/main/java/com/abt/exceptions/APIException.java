package com.abt.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class APIException extends Exception {
	private Integer statusCode;

	public APIException(String message) {
		super(message);
		this.statusCode=HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

	public APIException(Integer statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
	}

}
