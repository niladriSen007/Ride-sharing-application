package com.niladri.RideSharingApplication.service.rider;

import com.niladri.RideSharingApplication.dto.driver.DriverResponseDto;
import com.niladri.RideSharingApplication.dto.ride.RideDto;
import com.niladri.RideSharingApplication.dto.rideRequest.RideRequestDto;
import com.niladri.RideSharingApplication.dto.rider.RiderResponseDto;
import com.niladri.RideSharingApplication.model.rider.RiderModel;
import com.niladri.RideSharingApplication.model.user.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RiderServiceInterface {

	RideRequestDto requestRide(RideRequestDto rideRequestDto);

	RideDto cancelRide(Long rideId);

	DriverResponseDto rateDriver(Long rideId, Integer rating);

	RideDto getRideDetails(Long rideId);

	RiderResponseDto getRiderProfile();

	Page<RideDto> getRiderAllRides(PageRequest pageRequest);

	RiderModel createRiderProfile(UserModel user);

	RiderModel getCurrentRider();
}
