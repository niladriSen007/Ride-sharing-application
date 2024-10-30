package com.niladri.RideSharingApplication.exception;

public class DriverNotAuthorisedToStartRide extends RuntimeException {
	public DriverNotAuthorisedToStartRide() {
	}

	public DriverNotAuthorisedToStartRide(String message) {
		super(message);
	}
}
