package com.viniciuscarneiro.plataformapedidos.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer statusCode;
	private String message;
	private Long timeStamp;
	
	public StandardError(Integer statusCode, String message, Long timeStamp) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
}
