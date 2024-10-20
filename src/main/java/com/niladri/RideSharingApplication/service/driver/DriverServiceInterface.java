package com.niladri.RideSharingApplication.service.driver;

import com.niladri.RideSharingApplication.dto.driver.DriverResponseDto;
import com.niladri.RideSharingApplication.dto.ride.RideDto;

import java.util.List;

public interface DriverServiceInterface {

	RideDto acceptRide(Long rideId);

	RideDto cancelRide(Long rideId);

	RideDto startRide(Long rideId);

	RideDto endRide(Long rideId);

	RideDto rateRider(Long rideId, Integer rating);

	DriverResponseDto getDriverProfile();

	List<RideDto> getDriverAllRides();

}
