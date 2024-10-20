package com.niladri.RideSharingApplication.service.ride;

import com.niladri.RideSharingApplication.dto.ride.RideDto;
import com.niladri.RideSharingApplication.dto.rideRequest.RideRequestDto;
import com.niladri.RideSharingApplication.model.driver.DriverModel;
import com.niladri.RideSharingApplication.model.enums.RideStatus;
import com.niladri.RideSharingApplication.model.ride.RideModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideServiceInterface {
	RideDto getRideById(Long rideId);

	RideDto createNewRide(RideRequestDto rideDto, DriverModel driverModel);

	RideDto updateRideStatus(Long rideId, RideStatus status);

	Page<RideModel> getAllRidesOfRider(Long riderId, PageRequest pageRequest);

	Page<RideModel> getAllRidesOfDriver(Long driverId, PageRequest pageRequest);

	void matchWithDrivers(RideRequestDto rideRequestDto);
}
