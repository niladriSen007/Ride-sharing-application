package com.niladri.RideSharingApplication.exception;

public class RideAlreadyConfirmed extends RuntimeException {

	public RideAlreadyConfirmed() {
	}

	public RideAlreadyConfirmed(String message) {
		super(message);
	}
}
