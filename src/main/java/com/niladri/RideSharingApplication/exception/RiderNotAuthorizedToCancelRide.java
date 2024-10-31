package com.niladri.RideSharingApplication.exception;

public class RiderNotAuthorizedToCancelRide extends RuntimeException {

	public RiderNotAuthorizedToCancelRide() {
	}

	public RiderNotAuthorizedToCancelRide(String message) {
		super(message);
	}
}
