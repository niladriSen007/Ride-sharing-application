package com.niladri.RideSharingApplication.service.ride;

import com.niladri.RideSharingApplication.dto.ride.RideDto;
import com.niladri.RideSharingApplication.dto.rideRequest.RideRequestDto;
import com.niladri.RideSharingApplication.model.driver.DriverModel;
import com.niladri.RideSharingApplication.model.enums.RideStatus;
import com.niladri.RideSharingApplication.model.ride.RideModel;
import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideServiceInterface {
	RideDto getRideById(Long rideId);

	RideModel createNewRide(RideRequestModel ride, DriverModel driverModel);

	RideModel updateRideStatus(Long rideId, RideStatus status);

	Page<RideModel> getAllRidesOfRider(Long riderId, PageRequest pageRequest);

	Page<RideModel> getAllRidesOfDriver(Long driverId, PageRequest pageRequest);

	void matchWithDrivers(RideRequestDto rideRequestDto);
}
