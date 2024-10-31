package com.niladri.RideSharingApplication.exception;

public class RideStatusNotConfirmed extends RuntimeException {

	public RideStatusNotConfirmed() {
	}

	public RideStatusNotConfirmed(String message) {
		super(message);
	}
}
