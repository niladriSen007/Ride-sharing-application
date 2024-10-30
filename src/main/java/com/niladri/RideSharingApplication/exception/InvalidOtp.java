package com.niladri.RideSharingApplication.exception;

public class InvalidOtp extends RuntimeException {
	public InvalidOtp() {
	}

	public InvalidOtp(String message) {
		super(message);
	}
}
