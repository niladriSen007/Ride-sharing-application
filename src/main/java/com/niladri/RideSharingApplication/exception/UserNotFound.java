package com.niladri.RideSharingApplication.exception;

public class UserNotFound extends RuntimeException {
	public UserNotFound(String message) {
		super(message);
	}
}
