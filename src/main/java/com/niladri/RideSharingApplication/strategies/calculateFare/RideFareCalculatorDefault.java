package com.niladri.RideSharingApplication.strategies.calculateFare;

import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;
import com.niladri.RideSharingApplication.service.distance.DistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideFareCalculatorDefault implements RideFareCalculatorInterface {


	private final DistanceService distanceService;

	@Override
	public Double calculateFare(RideRequestModel rideRequest) {

		Double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),
				rideRequest.getDropLocation());
		return distance * RIDE_FARE_MULTIPLIER;
	}
}
