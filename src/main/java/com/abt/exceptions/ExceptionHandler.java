package com.abt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.abt.models.Response;

@ControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(APIException.class)
	public Response<Void> handleAPIExeption(APIException e) {
		return new Response<Void>(e.getStatusCode(), e.getMessage(), null);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public Response<Void> handleOtherException(Exception e) {
		return new Response<Void>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), null);

	}
}
