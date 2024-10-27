package com.niladri.RideSharingApplication.strategies.calculateFare;

import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;

public interface RideFareCalculatorInterface {

	Double RIDE_FARE_MULTIPLIER = 50.0;
	Double calculateFare(RideRequestModel rideRequest);
}
