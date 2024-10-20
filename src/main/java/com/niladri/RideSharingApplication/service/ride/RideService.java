package com.niladri.RideSharingApplication.service.ride;

import com.niladri.RideSharingApplication.dto.ride.RideDto;
import com.niladri.RideSharingApplication.dto.rideRequest.RideRequestDto;
import com.niladri.RideSharingApplication.model.driver.DriverModel;
import com.niladri.RideSharingApplication.model.enums.RideStatus;
import com.niladri.RideSharingApplication.model.ride.RideModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class RideService implements RideServiceInterface {
	@Override
	public RideDto getRideById(Long rideId) {
		return null;
	}

	@Override
	public RideDto createNewRide(RideRequestDto rideDto, DriverModel driverModel) {
		return null;
	}

	@Override
	public RideDto updateRideStatus(Long rideId, RideStatus status) {
		return null;
	}

	@Override
	public Page<RideModel> getAllRidesOfRider(Long riderId, PageRequest pageRequest) {
		return null;
	}

	@Override
	public Page<RideModel> getAllRidesOfDriver(Long driverId, PageRequest pageRequest) {
		return null;
	}

	@Override
	public void matchWithDrivers(RideRequestDto rideRequestDto) {

	}
}
