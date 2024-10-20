package com.niladri.RideSharingApplication.service.driver;

import com.niladri.RideSharingApplication.dto.driver.DriverResponseDto;
import com.niladri.RideSharingApplication.dto.ride.RideDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService implements DriverServiceInterface {
	@Override
	public RideDto acceptRide(Long rideId) {
		return null;
	}

	@Override
	public RideDto cancelRide(Long rideId) {
		return null;
	}

	@Override
	public RideDto startRide(Long rideId) {
		return null;
	}

	@Override
	public RideDto endRide(Long rideId) {
		return null;
	}

	@Override
	public RideDto rateRider(Long rideId, Integer rating) {
		return null;
	}

	@Override
	public DriverResponseDto getDriverProfile() {
		return null;
	}

	@Override
	public List<RideDto> getDriverAllRides() {
		return List.of();
	}
}
