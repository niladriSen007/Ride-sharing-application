package com.niladri.RideSharingApplication.strategies.matchingDriver;

import com.niladri.RideSharingApplication.dto.rideRequest.RideRequestDto;
import com.niladri.RideSharingApplication.model.driver.DriverModel;

import java.util.List;

public interface DriverMatchingInterface {
	List<DriverModel> findMatchingDrivers(RideRequestDto rideRequestDto);
}
