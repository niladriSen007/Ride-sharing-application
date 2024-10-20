package com.niladri.RideSharingApplication.strategies.calculateFare;

import com.niladri.RideSharingApplication.dto.rideRequest.RideRequestDto;

public class RideFareCalculatorDefault implements RideFareCalculatorInterface {


	@Override
	public double calculateFare(RideRequestDto rideRequestDto) {
		return 0;
	}
}
