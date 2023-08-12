package com.abt.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
	
	    private Integer statusCode;
	    private String message;
	    private T content;
  	
}
