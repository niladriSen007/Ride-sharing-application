package com.niladri.RideSharingApplication.strategies.matchingDriver;

import com.niladri.RideSharingApplication.dto.rideRequest.RideRequestDto;
import com.niladri.RideSharingApplication.model.driver.DriverModel;

import java.util.List;

public class DriverMatchingNearby implements DriverMatchingInterface{
	@Override
	public List<DriverModel> findMatchingDrivers(RideRequestDto rideRequestDto) {
		return List.of();
	}
}
