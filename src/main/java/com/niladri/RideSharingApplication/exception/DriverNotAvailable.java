package com.niladri.RideSharingApplication.exception;

public class DriverNotAvailable extends RuntimeException {

	public DriverNotAvailable() {
	}

	public DriverNotAvailable(String message) {
		super(message);
	}
}
