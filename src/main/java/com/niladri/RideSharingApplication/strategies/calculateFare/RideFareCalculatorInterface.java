package com.niladri.RideSharingApplication.strategies.calculateFare;

import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;

public interface RideFareCalculatorInterface {
	Double calculateFare(RideRequestModel rideRequest);
}
