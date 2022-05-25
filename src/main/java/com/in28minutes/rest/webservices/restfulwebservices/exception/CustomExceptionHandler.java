package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.weaver.reflect.InternalUseOnlyPointcutParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest webRequest) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				Arrays.asList(webRequest.getDescription(false)));
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest webRequest) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				Arrays.asList(webRequest.getDescription(false)));
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		final List<String> listOfFieldMessages = ex.getBindingResult()
				  .getFieldErrors()
				  .stream()
				  .map(FieldError::getDefaultMessage)
				  .collect(Collectors.toList());
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Validation failed",
				//ex.getBindingResult().getFieldError().getDefaultMessage().toString());
				listOfFieldMessages);
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
