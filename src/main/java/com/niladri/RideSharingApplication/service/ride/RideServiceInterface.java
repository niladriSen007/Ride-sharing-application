package com.niladri.RideSharingApplication.service.ride;

import com.niladri.RideSharingApplication.dto.ride.RideDto;
import com.niladri.RideSharingApplication.dto.rideRequest.RideRequestDto;
import com.niladri.RideSharingApplication.model.driver.DriverModel;
import com.niladri.RideSharingApplication.model.enums.RideStatus;
import com.niladri.RideSharingApplication.model.ride.RideModel;
import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;
import com.niladri.RideSharingApplication.model.rider.RiderModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideServiceInterface {
	RideModel getRideById(Long rideId);

	RideModel createNewRide(RideRequestModel ride, DriverModel driverModel);

	RideModel updateRideStatus(Long rideId, RideStatus status);

	Page<RideModel> getAllRidesOfRider(RiderModel riderModel, PageRequest pageRequest);

	Page<RideModel> getAllRidesOfDriver(DriverModel driver, PageRequest pageRequest);

}
