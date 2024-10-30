package com.niladri.RideSharingApplication.strategies.matchingDriver;

import com.niladri.RideSharingApplication.model.driver.DriverModel;
import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;
import com.niladri.RideSharingApplication.repository.driver.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DriverMatchingHighestRated implements DriverMatchingInterface{

	private final DriverRepository driverRepository;

	@Override
	public List<DriverModel> findMatchingDrivers(RideRequestModel rideRequest) {
		return driverRepository.findMatchingDriversNearbyAndHighestRated(
				rideRequest.getPickupLocation());
	}
}
