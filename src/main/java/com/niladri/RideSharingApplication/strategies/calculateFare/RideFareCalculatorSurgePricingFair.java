package com.niladri.RideSharingApplication.strategies.calculateFare;

import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;
import com.niladri.RideSharingApplication.service.distance.DistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareCalculatorSurgePricingFair implements RideFareCalculatorInterface{

	private final DistanceService distanceService;
	private static final Double SURGE_FARE_MULTIPLIER = 1.5;

	@Override
	public Double calculateFare(RideRequestModel rideRequest) {

		Double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),
				rideRequest.getDropLocation());
		return distance * RIDE_FARE_MULTIPLIER*SURGE_FARE_MULTIPLIER;
	}
}
