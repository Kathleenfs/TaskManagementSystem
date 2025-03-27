package com.kfss.TaskManagementSystem.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<String> handleInvalidRequest(InvalidRequestException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception ex) {
		return new ResponseEntity<>("Ocorreu um erro interno. Tente novamente mais tarde.",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleUserNotFound(UserNotFoundException e) {
		return e.getMessage();
	}

	@ExceptionHandler(UserAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleUserAlreadyExists(UserAlreadyExistsException e) {
		return e.getMessage();
	}

}
