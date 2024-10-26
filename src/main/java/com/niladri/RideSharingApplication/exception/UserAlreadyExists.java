package com.niladri.RideSharingApplication.exception;

public class UserAlreadyExists extends RuntimeException {

	public UserAlreadyExists() {
	}

	public UserAlreadyExists(String message) {
		super(message);
	}
}
