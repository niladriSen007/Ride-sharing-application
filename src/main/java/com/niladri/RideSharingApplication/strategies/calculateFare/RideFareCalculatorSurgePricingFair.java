package com.niladri.RideSharingApplication.strategies.calculateFare;

import com.niladri.RideSharingApplication.dto.rideRequest.RideRequestDto;
import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;

public class RideFareCalculatorSurgePricingFair implements RideFareCalculatorInterface{
	@Override
	public Double calculateFare(RideRequestModel rideRequest) {
		return 0.0;
	}
}
