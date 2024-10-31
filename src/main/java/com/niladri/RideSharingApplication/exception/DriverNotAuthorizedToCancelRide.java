package com.niladri.RideSharingApplication.exception;

public class DriverNotAuthorizedToCancelRide extends RuntimeException {

	public DriverNotAuthorizedToCancelRide() {
	}

	public DriverNotAuthorizedToCancelRide(String message) {
		super(message);
	}
}
