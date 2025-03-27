package com.kfss.TaskManagementSystem.util;

public class UserAlreadyExistsException extends RuntimeException {
	public UserAlreadyExistsException(String message) {
		super(message);
	}
}