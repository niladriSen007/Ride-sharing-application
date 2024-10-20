package com.niladri.RideSharingApplication.strategies.calculateFare;

import com.niladri.RideSharingApplication.dto.rideRequest.RideRequestDto;

public interface RideFareCalculatorInterface {
	double calculateFare(RideRequestDto rideRequestDto);
}
