package com.niladri.RideSharingApplication.service.rider;

import com.niladri.RideSharingApplication.dto.driver.DriverResponseDto;
import com.niladri.RideSharingApplication.dto.ride.RideDto;
import com.niladri.RideSharingApplication.dto.rideRequest.RideRequestDto;
import com.niladri.RideSharingApplication.dto.rider.RiderResponseDto;

import java.util.List;

public interface RiderServiceInterface {

	RideRequestDto requestRide(RideRequestDto rideRequestDto);

	RideDto cancelRide(Long rideId);

	DriverResponseDto rateDriver(Long rideId, Integer rating);

	RideDto getRideDetails(Long rideId);

	RiderResponseDto getRiderProfile();

	List<RideDto> getRiderAllRides();
}
