package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.util.Date;
import java.util.List;

public class ExceptionResponse {
	
	private Date timeStamp;
	private String message;
	private List<String> errorDescription;
	public ExceptionResponse(Date timeStamp, String message, List<String> errorDescription) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.errorDescription = errorDescription;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public List<String> getErrorDescription() {
		return errorDescription;
	}
	
	

}
