package com.niladri.RideSharingApplication.service.rideRequest;

import com.niladri.RideSharingApplication.model.rideRequest.RideRequestModel;

public interface RideRequestInterface {
	RideRequestModel getRideRequestById(Long rideRequestId);
	void updateRideRequest(RideRequestModel rideRequestModel);
}
