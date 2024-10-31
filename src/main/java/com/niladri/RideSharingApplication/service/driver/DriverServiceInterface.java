package com.niladri.RideSharingApplication.service.driver;

import com.niladri.RideSharingApplication.dto.driver.DriverResponseDto;
import com.niladri.RideSharingApplication.dto.ride.RideDto;
import com.niladri.RideSharingApplication.model.driver.DriverModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface DriverServiceInterface {

	RideDto acceptRide(Long rideRequestId);

	RideDto cancelRide(Long rideId);

	RideDto startRide(Long rideId,String otp);

	RideDto endRide(Long rideId);

	RideDto rateRider(Long rideId, Integer rating);

	DriverResponseDto getDriverProfile();

	Page<RideDto> getDriverAllRides(PageRequest pageRequest);

	DriverModel getCurrentDriver();

	DriverModel updateDriverAvailability(DriverModel driver, Boolean isAvailable);
}
