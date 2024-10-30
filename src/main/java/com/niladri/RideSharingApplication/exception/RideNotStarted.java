package com.niladri.RideSharingApplication.exception;

public class RideNotStarted extends RuntimeException {
	public RideNotStarted() {
	}

	public RideNotStarted(String message) {
		super(message);
	}
}
