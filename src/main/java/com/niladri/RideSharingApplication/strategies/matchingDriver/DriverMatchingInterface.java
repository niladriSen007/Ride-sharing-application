package com.niladri.RideSharingApplication.strategies.matchingDriver;

import com.niladri.RideSharingApplication.model.driver.DriverModel;
import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;

import java.util.List;

public interface DriverMatchingInterface {
	List<DriverModel> findMatchingDrivers(RideRequestModel rideRequest);
}
